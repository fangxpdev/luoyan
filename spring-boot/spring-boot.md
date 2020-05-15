# springboot

自动装载







### @Import注解

1. 导入普通的class类
2. 导入实现ImportBeanDefinitionRegistrar类
3. 导入实现ImportSelector类，可以批量加载



### BeanDefinition 重要属性介绍：

##### class：

可以替换成别的class，则获取bean会成为对应的class对象

##### Autowired：

```java
	NO(AutowireCapableBeanFactory.AUTOWIRE_NO),

	BY_NAME(AutowireCapableBeanFactory.AUTOWIRE_BY_NAME),

	BY_TYPE(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);
```

默认是NO，使用时必须显示使用@Autowired注解；BY_NAME/BY_TYPE见名知意，通过name或者type注入，需要提供setter方法

##### ConstructorArgumentValues

默认使用无参构造方法，可以通过ConstructorArgumentValues设置对应的有参构造器



### springboot 整合mybatis原理：

1. @MapperScan()  import:`org.mybatis.spring.annotation.MapperScannerRegistrar`实现`ImportBeanDefinitionRegistrar`;

2. 注册beanDefinition,实际注册中使用`org.mybatis.spring.mapper.MapperScannerConfigurer`该类实现`BeanDefinitionRegistryPostProcessor`

接口`postProcessBeanDefinitionRegistry`方法；

3. `org.springframework.context.annotation.ClassPathBeanDefinitionScanner#scan`扫描配置的路径下的所有mapper

4. `org.mybatis.spring.mapper.ClassPathMapperScanner#processBeanDefinitions`处理所有mapper的beanDefinition

5. 处理逻辑：

   ```java
   definition.getConstructorArgumentValues().addGenericArgumentValue(definition.getBeanClassName()); // issue #59
   definition.setBeanClass(this.mapperFactoryBean.getClass());
   definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
   ```

   对应的mapper接口类，beanClass设置为mapperFactoryBean，修改为有参构造方法(mapper接口类名),autowireMode为by_type；bean初始化过程实际生成的是beanName为mapper名，类为mapperFactoryBean，由于mapperFactoryBean是一个FactoryBean实际获取bean是调用其getObject方法，生产真正mapper接口的代理对象。



### springboot 自动配置原理：

springboot注解：`@SpringBootApplication` 

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
      @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
```

其中使用`@SpringBootConfiguration`:表示类似于传统的xml配置中的xml中间里面可以配置各种bean，即可以在启动类中配置@Bean可正常使用；

@ComponentScan默认扫描的是当前包路径及子包路径，使用时需注意；

@EnableAutoConfiguration注解是自动配置的核心：`@Import(AutoConfigurationImportSelector.class):`

`org.springframework.boot.autoconfigure.AutoConfigurationImportSelector#getCandidateConfigurations`获取`META-INF/spring.factories`

目录下的所有配置；过滤后自动配置类导入容器。










# sspring原理

### springIoc

控制反转(目的)、依赖注入(手段)

控制反转是由容器控制，控制对象是bean对象，创建对象被反转由spring容器创建



@Configuration作用

保证bean作用范围单例，被configuration注解的会被代理



benDefinition



### springIOC容器是什么？

singletonObjects???   很多组件共同组成，不仅仅是包含单例对象的容器

一组组件集合  beanDefinitionMap、beanPostProcessor....



### spring提供的扩展类

```
1. FactroyBean: 本身是一个bean，getObject方法可获取另一个bean，用于bean的初始化较重的类
2. BeanPostProcessor：在每个bena初始化前后做操作
3. InstantiationAwareBeanPostProcessor：在Bean实例化前后做一些操作 
2和3有啥区别呢？ 一个是初始化 一个是实例化
4. BeanNameAware、ApplicationContextAware 和 BeanFactoryAware
实现了Aware接口，可以获取bean的name、applicationContext、beanFactory等信息
5. BeanFactoryPostProcessor
Spring允许在Bean创建之前，读取Bean的元属性，并根据自己的需求对元属性进行改变，比如将Bean的scope从singleton改变为prototype。其实修改的是beanDefinition 
6. InitialingBean：在属性设置完毕后做一些自定义操作 
7. DisposableBean： 在关闭容器前做一些操作。

```



### springIoc源码

源码脉络：

xml/annotation ---(parse)---> beanDefinition,放入BeanDefinitionMap&beanDefinitionNames中

 --->遍历beanDefinition,初始化bean ---->bean初始化完成放入singletonObjects中

```java
org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBean
	>org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
		#resolveBeforeInstantiation ( InstantiationAwareBeanPostProcessor before方法执行)
	>org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#doCreateBean		>org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
					#createBeanInstance (实例化)
	>org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
		#populateBean	(依赖注入 InstantiationAwareBeanPostProcessor after方法执行 )	      					>org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
		#initializeBean	(初始化 BeanPostProcessor  before -> PostConstruct ->InitializingBean
		->init-method ->BeanPostProcessor  after)
		
```

singleton bean实例化与初始化完成后方存到SingletonObjects容器中

prototype是每次使用时创建

执行顺序：

```text
1.aware 方法调用 ----- ApplicationContextAware ----  
2.InstantiationAwareBeanPostProcessor方法 <---person postProcessBeforeInstantiation--->
3.反射构造方法实例化 -----bean 实例化-----  
4.InstantiationAwareBeanPostProcessor方法 <---person postProcessAfterInstantiation--->
5.BeanPostProcessor方法  ------Person(name=luoyan, sex=女) postProcessBeforeInitialization---
6.@PostConstruct 方法执行-----PostConstruct init ------
7.实现InitializingBean方法执行 ----InitializingBean init----
8.init-method 方法执行 init-method init
9.BeanPostProcessor方法 ------Person(name=nono, sex=女) postProcessAfterInitialization-------
10.ApplicationListener方法回调 ------ApplicationListener--------
```



### spring循环依赖

##### 三级缓存：

singletonObjects：存放单例bean已经实例化

singletonFactories：存放的是工厂

earlySingletonObjects：存放临时对象，未初始化完成的bean



单例才能循环依赖，原型不能循环依赖



##### 为什么ginletonFactories要存工厂？

工厂需要完成类似于代理生成等功能，如果不使用工厂直接存入对象，注入时则是未初始化完成的对象，如未被代理



### springAOP 

入口1：

```java
org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
		#applyBeanPostProcessorsAfterInitialization
	>org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#postProcessAfterInitialization 
```

入口2：

解决循环依赖生成代理对象入口：

org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#getEarlyBeanReference

```
AnnotationAwareAspectJAutoProxyCreator
```



事务切面与自定义切面如何控制优先级？

@Ordered 默认最低优先级 integer最大值



aop初始化及调用过程理解：

```java
org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#resolveBeforeInstantiation  
		>org.springframework.aop.aspectj.annotation.BeanFactoryAspectJAdvisorsBuilder#buildAspectJAdvisors
```

首先会将@Aspect注解的bean放入 advisorsCache中；

springioc初始化bean调用后置处理器，其中包含AnnotationAwareAspectJAutoProxyCreator处理器，判断bean是否需要被代理

> org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#wrapIfNecessary
>
> org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator#getAdvicesAndAdvisorsForBean
>
> org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#createProxy
>
> org.springframework.aop.framework.ProxyFactory#getProxy

创建代理对象；

执行过程：已cglib代理为例

```java
org.springframework.aop.framework.CglibAopProxy.DynamicAdvisedInterceptor#intercept
  org.springframework.aop.framework.AdvisedSupport#getInterceptorsAndDynamicInterceptionAdvice(获取advisors)
```

获取advisor链，链式调用



### springMVC

springMVC父子容器：

![mvc context hierarchy](./image/mvc-context-hierarchy.png)

配置项：

```xml
<context-param>
   <param-name>contextConfigLocation</param-name>
   <param-value>classpath:spring-context.xml</param-value>
</context-param>

<listener>
   <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

<servlet>
   <servlet-name>springmvc</servlet-name>
   <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
   <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring-mvc.xml</param-value>
   </init-param>
   <load-on-startup>1</load-on-startup>
</servlet>
```

* ContextLoaderListener   ----->spring-context.xml      父容器配置

* DispatcherServlet  ---->spring-mvc.xml	子容器配置



ContextLoaderListener 回调方法触发父容器启动

DispatcherServlet 触发字容易启动



容器注册方式：

1. @WebServlet   @WebListener   @WebFilter

2. xml
3. spi机制  

### spring  spi



```
javax.servlet.ServletContainerInitializer
	>org.springframework.web.SpringServletContainerInitializer
```

spring 通过spi机制，指定实现类SpringServletContainerInitializer，启动时会调用所有

> org.springframework.web.WebApplicationInitializer

的实现类；



### spring    javaConfig 去xml配置

```java
public class LuoyanServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```

原理：

1. spring spi机制，使用SpringServletContainerInitializer启动调用WebApplicationInitializer的实现类的onStartUp()
2. AbstractAnnotationConfigDispatcherServletInitializer为实现WebApplicationInitializer的抽象类
3. 配置父子容器配置类以及servletmapping

方法执行流程：

```java
org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#onStartup
	>org.springframework.web.context.AbstractContextLoaderInitializer#onStartup //(父容器)
		>org.springframework.web.context.AbstractContextLoaderInitializer#registerContextLoaderListener
  	>org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
  		#createRootApplicationContext
  	>ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		>	listener.setContextInitializers(getRootApplicationContextInitializers());
		>	servletContext.addListener(listener);  //servlet添加listener
      
	>org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#registerDispatcherServlet //(子容器)
    >org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
      #createServletApplicationContext    
    >org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#createDispatcherServlet  
```

流程：

1. 先创建父容器`AnnotationConfigWebApplicationContext`，将listener添加到servelt上线文中，等待触发listener

2. 创建子容器`AnnotationConfigWebApplicationContext`,再创建DispatcherServlet

3. 触发容器listener,执行`org.springframework.web.context.ContextLoaderListener#contextInitialized`，初始化父容器

```java
org.springframework.web.context.ContextLoader#initWebApplicationContext
	>org.springframework.web.context.ContextLoader#configureAndRefreshWebApplicationContext
		>org.springframework.context.support.AbstractApplicationContext#refresh
```

到了熟悉的refresh流程

4. 触发子容器servlet的init()方法

   ```java
   org.springframework.web.servlet.HttpServletBean#init
   	>org.springframework.web.servlet.FrameworkServlet#initServletBean
   		>org.springframework.web.servlet.FrameworkServlet#initWebApplicationContext
     		>org.springframework.web.servlet.FrameworkServlet#configureAndRefreshWebApplicationContext
     			>org.springframework.context.support.AbstractApplicationContext#refresh
   ```

   子容器初始化

   
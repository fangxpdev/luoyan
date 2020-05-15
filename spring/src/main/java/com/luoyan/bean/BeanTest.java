package com.luoyan.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author michael
 */
public class BeanTest {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Caculate caculate = (Caculate) context.getBean("caculate");
        caculate.div(6, 2);

//        Person person = (Person)context.getBean("person");
//        System.out.println(person);

//        Person person1 = context.getBean(Person.class);
//        System.out.println(person1);

//        MoonFactoryBean bean = context.getBean(MoonFactoryBean.class);
//
//        Moon moon = (Moon) bean.getObject();
//        System.out.println(moon);

    }

}

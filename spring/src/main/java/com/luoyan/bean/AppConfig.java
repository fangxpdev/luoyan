package com.luoyan.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.luoyan.bean")
public class AppConfig {

    @Bean(initMethod = "initPerson")
    public Person person() {
        System.out.println("-----bean 实例化-----");
        Person person = new Person();
        person.setName("luoyan");
        person.setSex("女");
        return person;
    }

}

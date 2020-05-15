package com.luoyan.bean;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 验证初始化方法执行顺序：
 * 1. postConstruct
 * 2. initializingBean
 * 3. init-method
 *
 * @author michael
 */
@Data
public class Person implements InitializingBean {

    private String name;

    private String sex;

    public void initPerson() {
        System.out.println("init-method init");
    }

    @PostConstruct
    public void init() {
        System.out.println("-----PostConstruct init ------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----InitializingBean init----");
    }
}

package com.luoyan.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.SpringServletContainerInitializer;

@Component
public class A {

    @Autowired
    private B b;


    public A() {
        System.out.println("A created");
    }

    public void useB() {
        b.print();
    }

}

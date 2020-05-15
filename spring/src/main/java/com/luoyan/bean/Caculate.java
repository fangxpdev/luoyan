package com.luoyan.bean;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component
public class Caculate {

    public void print() {

        Caculate o = (Caculate) AopContext.currentProxy();
        System.out.println("------c print--------");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        return a / b;
    }

}

package com.luoyan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AInvocationHandler implements InvocationHandler {

    A a;

    public AInvocationHandler(A a) {
        this.a = a;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---jdk proxy begin----");
        Object invoke = method.invoke(a, args);
        System.out.println("---jdk proxy end-----");
        return invoke;
    }
}

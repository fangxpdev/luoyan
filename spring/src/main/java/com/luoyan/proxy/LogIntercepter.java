package com.luoyan.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogIntercepter implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("----log begin ----");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("---log end ---");
        return object;
    }
}

package com.luoyan.proxy;

import java.lang.reflect.Proxy;

/**
 * @author michael
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        A a = new AImpl();
        A proxyInstance = (A)Proxy.newProxyInstance(a.getClass().getClassLoader(), new Class[]{A.class},
                new AInvocationHandler(a));
        proxyInstance.print();

    }

}

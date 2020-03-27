package com.luoyan.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 模拟反射攻击
 * <p>
 * 需要在私有构造方法中添加判断 抛异常
 */
public class ReflectAttack {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        SingletonObject5 instance = SingletonObject5.getInstance();
        SingletonObject5 instance1 = null;
        Constructor<SingletonObject5> declaredConstructor = SingletonObject5.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        instance1 = declaredConstructor.newInstance();

        System.out.println("instance1:" + instance1);

        System.out.println("equals:" + (instance == instance1));
    }

}

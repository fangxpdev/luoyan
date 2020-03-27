package com.luoyan.singleton;

/**
 * 饿汉式
 * 不能懒加载
 */
public class SingletonObject1 {

    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {

    }

    public static SingletonObject1 getInstance() {
        return instance;
    }

}

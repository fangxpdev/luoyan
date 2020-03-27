package com.luoyan.singleton;

public class SingletonObject5 {

    private SingletonObject5() {

        if (InstanceHolder.instance != null) {
            throw new RuntimeException("不允许实例化多次");
        }

    }

    /**
     * static 只初始化一次
     */
    private static class InstanceHolder {

        private final static SingletonObject5 instance = new SingletonObject5();

    }

    public static SingletonObject5 getInstance() {
        return InstanceHolder.instance;
    }
}

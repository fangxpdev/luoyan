package com.luoyan.singleton;

/**
 * 懒加载
 */
public class SingletonObject2 {

    private static SingletonObject2 instance;

    private SingletonObject2() {

    }

    /**
     * 有并发问题
     * @return
     */
    public static SingletonObject2 getInstance() {
        //有并发问题
        if (null == instance) {
            instance = new SingletonObject2();
        }
        return SingletonObject2.instance;
    }

}

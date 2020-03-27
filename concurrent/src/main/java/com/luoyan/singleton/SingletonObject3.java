package com.luoyan.singleton;

/**
 * double check
 */
public class SingletonObject3 {

    private static SingletonObject3 instance;

    private SingletonObject3() {
    }

    /**
     * double check
     * instance 初始化未完成，其他线程就使用 可能导致空指针
     *
     * @return
     */
    public static SingletonObject3 getInstance() {

        if (null == instance) {
            synchronized (SingletonObject3.class) {
                if (null == instance) {
                    instance = new SingletonObject3();
                }
            }
        }

        return instance;

    }

}

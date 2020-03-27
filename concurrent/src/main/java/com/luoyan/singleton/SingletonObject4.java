package com.luoyan.singleton;

public class SingletonObject4 {

    /**
     * volatile 保证先写完 再读  不能内存重排序
     */
    private static volatile SingletonObject4 instance;

    private SingletonObject4() {
        //初始化动作
        int i = 0;
        int j = 10;
    }

    /**
     * double check
     * instance 初始化未完成，其他线程就使用 可能导致空指针
     *
     * @return
     */
    public static SingletonObject4 getInstance() {

        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance) {
                    instance = new SingletonObject4();
                    //这段代码可以分解成3行伪代码
                    // memory = allocate(); 1.分配对象的内存空间
                    // createInstance(memory); 2.初始化对象
                    // instance = memory  3. 设置instance执行刚分配的内存地址
                    /** 2和3 两部存在重排序可能 */
                }
            }
        }

        return instance;

    }


}

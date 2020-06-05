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

            /**
             *  0 aconst_null
             *  1 getstatic #2 <com/luoyan/singleton/SingletonObject4.instance>
             *  4 if_acmpne 39 (+35)
             *  7 ldc #3 <com/luoyan/singleton/SingletonObject4>
             *  9 dup
             * 10 astore_0
             * 11 monitorenter
             * 12 aconst_null
             * 13 getstatic #2 <com/luoyan/singleton/SingletonObject4.instance>
             * 16 if_acmpne 29 (+13)
             * 19 new #3 <com/luoyan/singleton/SingletonObject4>
             * 22 dup
             * 23 invokespecial #4 <com/luoyan/singleton/SingletonObject4.<init>>
             * 26 putstatic #2 <com/luoyan/singleton/SingletonObject4.instance>
             * 29 aload_0
             * 30 monitorexit
             * 31 goto 39 (+8)
             * 34 astore_1
             * 35 aload_0
             * 36 monitorexit
             * 37 aload_1
             * 38 athrow
             * 39 getstatic #2 <com/luoyan/singleton/SingletonObject4.instance>
             * 42 areturn
             */
        }

        return instance;

    }



}

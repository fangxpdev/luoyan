package com.luoyan.actomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    /**
     * 1.可见性
     * 2.内存屏障，有序性
     * 3.单变量操作原子性 a++不保证原子性
     */
    private volatile int value;

    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {

        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }


}

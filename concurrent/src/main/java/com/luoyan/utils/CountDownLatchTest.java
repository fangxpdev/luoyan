package com.luoyan.utils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " work");
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " work");
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        System.out.println(" main thread done");


    }

}

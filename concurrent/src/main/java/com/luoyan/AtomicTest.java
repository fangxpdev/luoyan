package com.luoyan;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * volatile 不能保证并发操作更新问题
 */
public class AtomicTest {

    private static volatile int a = 0;


    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        tpe.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 100000; i++) {
            tpe.submit(new Task());
        }

        Thread.sleep(5000);
        System.out.println(a);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            a++;
        }
    }


}

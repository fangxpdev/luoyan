package com.luoyan.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CacheThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            //任务添加速度如果小于任务执行速度，则会复用线程
            //反之，则会创建新的线程执行任务
            Thread.sleep(100L);

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(finalI + "当前线程" + Thread.currentThread().getName());
                }
            });
        }

        cachedThreadPool.shutdown();

    }


}

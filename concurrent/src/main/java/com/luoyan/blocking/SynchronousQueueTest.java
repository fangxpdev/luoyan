package com.luoyan.blocking;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue synchronousQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                synchronousQueue.put(1);
                System.out.println("--->");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(()->{
            try {
                synchronousQueue.take();
                System.out.println("--->>>");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }).start();


    }

}

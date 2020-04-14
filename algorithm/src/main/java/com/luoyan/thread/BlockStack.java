package com.luoyan.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockStack {

    private int[] data;

    private int count;

    private int capacity;

    private static final Lock lock = new ReentrantLock(true);

    private static final Condition con = lock.newCondition();

    public BlockStack(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
    }

    public void put(int val) {

        try {
            lock.lock();
            while (count == capacity) {
                con.await();
            }

            data[count++] = val;
            con.signal();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public int take() {
        int temp = 0;

        try {
            lock.lock();
            while (count <= 0) {
                con.await();
            }
            temp = data[--count];
            con.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return temp;
    }

    public static void main(String[] args) {

        BlockStack queue = new BlockStack(2);

        queue.put(1);
        queue.put(2);

        System.out.println("put 12 ok");

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("take : " + queue.take());

        }, "tt").start();

        queue.put(3);

        System.out.println("put 3 ok");

        for (int datum : queue.data) {
            System.out.print(datum+",");
        }
//
//        new Thread(() -> {
//            while (true) {
//                queue.put(1);
//                queue.put(2);
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//
//        }, "t1").start();
//
//
//        new Thread(() -> {
//
//            queue.take();
//
//        }, "t2").start();


    }


}

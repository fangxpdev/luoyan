package com.luoyan.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue {

    private int[] data;

    private int capacity;

    private int readIndex;

    private int writeIndex;

    private Lock lock = new ReentrantLock();

    private Condition fullCondition = lock.newCondition();

    private Condition emptyCondition = lock.newCondition();


    public BlockQueue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    private int take() {
        lock.lock();
        try {

            while (readIndex == writeIndex) {
                emptyCondition.await();
            }

            if (readIndex == capacity) {
                readIndex = 0;
            }

            int index = readIndex++;
            fullCondition.signal();
            return data[index];

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return 0;
    }

    private void put(int val) {
        lock.lock();
        try {
            while (writeIndex == capacity) {
                fullCondition.await();
                writeIndex = 0;
            }

            if (writeIndex == readIndex - 1) {
                fullCondition.await();
            }

            data[writeIndex++] = val;

            emptyCondition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        BlockQueue queue = new BlockQueue(5);

        new Thread(() -> {
            queue.put(1);
            System.out.println(Thread.currentThread().getName() + " put 1");
            queue.put(2);
            System.out.println(Thread.currentThread().getName() + " put 2");
            queue.put(3);
            System.out.println(Thread.currentThread().getName() + " put 3");
            queue.put(4);
            System.out.println(Thread.currentThread().getName() + " put 4");
            queue.put(5);
            System.out.println(Thread.currentThread().getName() + " put 5");
            queue.put(6);
            System.out.println(Thread.currentThread().getName() + " put 6");

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            queue.put(7);
            System.out.println(Thread.currentThread().getName() + " put 7");
        }, "t1").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " take" + queue.take());
            System.out.println(Thread.currentThread().getName() + " take" + queue.take());
            System.out.println(Thread.currentThread().getName() + " take" + queue.take());
            System.out.println(Thread.currentThread().getName() + " take" + queue.take());
            System.out.println(Thread.currentThread().getName() + " take" + queue.take());
            System.out.println(Thread.currentThread().getName() + " take" + queue.take());

        }, "t2").start();


        Thread.sleep(1000L);
        System.out.println(Thread.currentThread().getName() + " take" + queue.take());

    }


}

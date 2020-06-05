package com.luoyan.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue2 {

    private int[] data;

    private int readIndex;

    private int writeIndex;

    private int count;

    private int capacity;

    private Lock lock = new ReentrantLock();

    private Condition fullCondition = lock.newCondition();

    private Condition emptyCondition = lock.newCondition();

    public BlockQueue2(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public void put(int val) {
        lock.lock();
        try {
            while (writeIndex == capacity || count == capacity) {
                fullCondition.await();

            }
            count++;
            data[writeIndex++] = val;

            if (writeIndex == capacity) {
                writeIndex = 0;
            }

            emptyCondition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int take() {
        lock.lock();
        try {
            while (count == 0) {
                emptyCondition.await();
            }

            int res = data[readIndex++];
            count--;
            if (readIndex == capacity) {
                readIndex = 0;
            }
            fullCondition.signal();
            return res;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return 0;
    }

    public static void main(String[] args) throws InterruptedException {

        BlockQueue2 queue = new BlockQueue2(5);

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

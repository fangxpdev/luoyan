package com.luoyan.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static int a = 0;

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        new Thread(new WriteTask()).start();

        new Thread(new ReaderTask()).start();

    }

    public void writer() {

        lock.lock();

        try {
            a++;
            System.out.println("writer a++");

        } finally {
            lock.unlock();
        }

    }


    public void reader() {

        lock.lock();

        try {
//            int i = a;
            System.out.println(Thread.currentThread().getName() + "reader i = " + a);

        } finally {
            lock.unlock();
        }

    }

    static class WriteTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " write " + ++a);
            }

        }
    }

    static class ReaderTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " reader a =  " + a);
            }
        }
    }
}

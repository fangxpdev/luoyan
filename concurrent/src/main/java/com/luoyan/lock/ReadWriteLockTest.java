package com.luoyan.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static final Lock wirteLock = readWriteLock.writeLock();

    private static final Lock readLock = readWriteLock.readLock();

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        new Thread(ReadWriteLockTest::read).start();

        new Thread(ReadWriteLockTest::write).start();


        new Thread(ReadWriteLockTest::read).start();

    }

    private static void write() {


        try {
            wirteLock.lock();
            list.add(String.valueOf(System.currentTimeMillis()));
            System.out.println(Thread.currentThread().getName() + " writing...");
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            wirteLock.unlock();
        }
    }

    private static void read() {

        try{
            readLock.lock();
            list.forEach(System.out::println);
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }

    }


}

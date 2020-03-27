package com.luoyan.actomic;

import java.util.concurrent.atomic.AtomicInteger;

public class BdLock {

    private AtomicInteger lock = new AtomicInteger(0);

    private Thread lockThread;

    public boolean getLock() {

        if (lock.compareAndSet(0, 1)) {
            lockThread = Thread.currentThread();
            System.out.println("get lock success!!!");
            return true;
        }
        System.out.println("get Lock failed!!!");

        return false;
    }

    public boolean unlock() {

        if (lock.get() == 0) {
            return true;
        } else if (lockThread == Thread.currentThread()) {
            lockThread = null;
            return lock.compareAndSet(1, 0);
        }

        return false;
    }


}

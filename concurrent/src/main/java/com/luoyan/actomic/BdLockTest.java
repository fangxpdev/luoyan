package com.luoyan.actomic;

import java.util.stream.IntStream;

public class BdLockTest {

    private static final BdLock lock = new BdLock();

    public static void main(String[] args) {

        IntStream.range(1,10).forEach((i)->{
            new Thread(()->{
                try{
                    if (lock.getLock()) {
                        try {
                            doSth();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("undo....");
                    }
                } finally {
                    if (lock.unlock()) {
                        System.out.println("unlock success....");
                    }
                }

            }).start();
        });

    }

    private static void doSth() throws InterruptedException {
        System.out.println("do sth.....");
        Thread.sleep(10000L);
    }

}

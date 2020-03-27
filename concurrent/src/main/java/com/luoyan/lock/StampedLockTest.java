package com.luoyan.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

public class StampedLockTest {

    public static final StampedLock lock = new StampedLock();

    public static final List<Long> DATA = new ArrayList<>();

    public static void main(String[] args) {


    }


    private static void read() {

        long stamp = lock.tryOptimisticRead();
        if (lock.validate(stamp)) {
            try {
                stamp = lock.readLock();
                Optional.of(DATA.stream().map(String::valueOf)
                        .collect(Collectors.joining("#", "R-", "")))
                        .ifPresent(System.out::println);

                sleep(3);

            } finally {
                lock.unlockRead(stamp);
            }
        }


    }

    private static void sleep(long sec) {

        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

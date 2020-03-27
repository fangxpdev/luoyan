package com.luoyan.actomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnsafeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {

        Unsafe unsafe = getUnsafe();
        System.out.println(unsafe);

//        Counter counter = new StupidCounter();
//        Counter counter = new SyncCounter();
//        Counter counter = new LockCounter();
//        Counter counter = new AtomicCounter();
        Counter counter = new CASCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new CounterRunnable(counter, 100000));
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        long end = System.currentTimeMillis();
        System.out.println("result count : " + counter.getCount() + " time : " + (end - startTime));

    }


    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);

    }

    static class StupidCounter implements Counter {

        private long count = 0L;

        @Override
        public void increment() {
            count++;
        }

        @Override
        public long getCount() {
            return count;
        }
    }

    static class SyncCounter implements Counter {

        private long count = 0L;

        @Override
        public synchronized void increment() {
            count++;
        }

        @Override
        public long getCount() {
            return count;
        }
    }

    static class LockCounter implements Counter {

        private long count = 0L;

        private static final Lock lock = new ReentrantLock();

        @Override
        public  void increment() {
            try{
                lock.lock();
                count++;
            }finally {
                lock.unlock();
            }
        }

        @Override
        public long getCount() {
            return count;
        }
    }

    static class AtomicCounter implements Counter {

        private AtomicLong count = new AtomicLong(0);

        private static final Lock lock = new ReentrantLock();

        @Override
        public  void increment() {
            try{
                lock.lock();
                count.incrementAndGet();
            }finally {
                lock.unlock();
            }
        }

        @Override
        public long getCount() {
            return count.get();
        }
    }

    static class CASCounter implements Counter {

        private volatile long count = 0;

        private Unsafe unsafe;

        private long offset;

        public CASCounter() throws NoSuchFieldException, IllegalAccessException {
            this.unsafe = getUnsafe();
            this.offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("count"));
        }

        @Override
        public  void increment() {
            long current = count;
            while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)) {
                current = count;
                count++;
            }
        }

        @Override
        public long getCount() {
            return count;
        }
    }


    interface Counter {

        void increment();

        long getCount();

    }

    static class CounterRunnable implements Runnable {

        private final Counter counter;

        private final int num;

        public CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {

            for (int i = 0; i < num; i++) {
                counter.increment();
            }

        }
    }

}

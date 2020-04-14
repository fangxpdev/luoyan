package com.luoyan.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = create(5);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(() -> {
            queue.remove("1");
        }, 100, TimeUnit.MICROSECONDS);

        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        System.out.println(queue.offer("6"));
        queue.put("7");
        System.out.println(queue.size());

    }


    public static <T> ArrayBlockingQueue<T> create(int size) {

        return new ArrayBlockingQueue<>(size);
    }

}

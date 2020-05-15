package com.luoyan.queue.test;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {

    public static void main(String[] args) {

        Queue<String> queue = new ArrayBlockingQueue<>(4);

        System.out.println("poll : " + queue.poll());

        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        //queue is full
//        queue.add("5");
        System.out.println(queue.poll());

        System.out.println(queue.remove());

        System.out.println("size : " + queue.size());

        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("iterator : " + next);
        }

    }

}

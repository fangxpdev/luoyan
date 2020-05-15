package com.luoyan.queue.test;

import java.util.Arrays;
import java.util.LinkedList;

public class DequeTest {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        String[] array = new String[]{"1", "2", "3"};

        list.addAll(Arrays.asList(array));

        System.out.println("pop : " + list.poll());

        System.out.println("size : " + list.size());



    }

}

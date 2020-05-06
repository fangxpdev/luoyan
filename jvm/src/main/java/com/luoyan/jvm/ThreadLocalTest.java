package com.luoyan.jvm;

public class ThreadLocalTest {

    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {

        local.set("1");

    }

}

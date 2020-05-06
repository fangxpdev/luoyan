package com.luoyan.jvm;

public class VolatileVisibleTest {

    public static  boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "wait data...");

            while (!flag) {

            }
            System.out.println(Thread.currentThread().getName() + " ====success");

        }, "t1").start();

        Thread.sleep(2000);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " prepare data...");
            flag = true;
            System.out.println(Thread.currentThread().getName() + " update data ok...");
        }, "t2").start();
    }


}

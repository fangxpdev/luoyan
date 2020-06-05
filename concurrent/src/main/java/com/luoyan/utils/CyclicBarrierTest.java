package com.luoyan.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2, new A());


    public static void main(String[] args) {

        new Thread(() -> {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +  1);
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +  2);
    }

    static class A implements  Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() +  3);
        }
    }

}

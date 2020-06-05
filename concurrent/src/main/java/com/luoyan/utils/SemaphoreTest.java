package com.luoyan.utils;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();
        semaphore.release();
    }

}

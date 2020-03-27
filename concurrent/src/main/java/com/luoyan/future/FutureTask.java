package com.luoyan.future;

public interface FutureTask<T> {

    T call() throws InterruptedException;
}

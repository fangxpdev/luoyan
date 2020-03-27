package com.luoyan.future;

public interface Future<T> {

    T get() throws InterruptedException;

    void done(T result);
}

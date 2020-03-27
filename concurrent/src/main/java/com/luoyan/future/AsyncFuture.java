package com.luoyan.future;

public class AsyncFuture<T> implements Future<T> {


    private static volatile boolean done = false;

    private T result;

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                this.wait();
            }
        }
        return result;
    }

    @Override
    public void done(T result) {
        synchronized (this) {
            this.result = result;
            done = true;
            this.notifyAll();
        }
    }


}

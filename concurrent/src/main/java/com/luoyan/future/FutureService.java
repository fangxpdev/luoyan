package com.luoyan.future;

import java.util.function.Consumer;

public class FutureService {

    public <T> Future<T> submit(FutureTask<T> task) {

        Future future = new AsyncFuture();

        new Thread(() -> {
            T result = null;
            try {
                result = task.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.done(result);
        }).start();

        return future;

    }

    /**
     * 回调方式
     * @param task
     * @param consumer
     * @param <T>
     * @return
     */
    public <T> Future<T> submit(FutureTask<T> task, Consumer<T> consumer) {

        Future future = new AsyncFuture();

        new Thread(() -> {
            T result = null;
            try {
                result = task.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.done(result);
            consumer.accept(result);
            
        }).start();

        return future;

    }


}

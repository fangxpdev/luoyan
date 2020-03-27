package com.luoyan.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinRecursiveTask {

    private static final int MAX_THRESHOLD = 3;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new CaculateTask(0, 10));

        System.out.println(future.get());

    }


    static class CaculateTask extends RecursiveTask<Integer> {

        private int start;

        private int end;

        public CaculateTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            if (end - start <= MAX_THRESHOLD) {
                return IntStream.rangeClosed(start, end).sum();
            } else {
                int middle = (start + end) / 2;
                CaculateTask leftTask = new CaculateTask(start, middle);
                CaculateTask rightTask = new CaculateTask(middle + 1, end);

                leftTask.fork();
                rightTask.fork();

                return leftTask.join() + rightTask.join();

            }
        }
    }


}

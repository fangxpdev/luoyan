package com.luoyan.singleton;


import java.util.stream.IntStream;

public class SingletonObject6 {

    private SingletonObject6() {

    }

    /**
     * final 只会装载一次
     */
    private enum Singleton{
        INSTANCE;

        private final SingletonObject6 instance;

        /**
         * private 只会装载一次
         */
        Singleton() {
            instance = new SingletonObject6();
        }

        public SingletonObject6 getInstance() {
            return instance;
        }
    }

    public static SingletonObject6 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 100).forEach(i -> new Thread(() -> System.out.println(SingletonObject6.getInstance())).start());

    }
}

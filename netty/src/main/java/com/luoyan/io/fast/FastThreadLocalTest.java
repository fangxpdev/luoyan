package com.luoyan.io.fast;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

public class FastThreadLocalTest {

    private static FastThreadLocal<String> local1 = new FastThreadLocal<>();
    private static FastThreadLocal<String> local2 = new FastThreadLocal<>();


    public static void main(String[] args) {

        new FastThreadLocalThread(() -> {
                local1.set("a1");
                local2.set("a2");

                System.out.println("t1 : " + local1.get());
                System.out.println("t1 : " + local2.get());
        }, "t1").start();


        new FastThreadLocalThread(() -> {
            local1.set("b1");
            local2.set("b2");

            System.out.println("t2 : " + local1.get());
            System.out.println("t2 : " + local2.get());
        }, "t2").start();

        System.out.println("main:" + local1.get());

    }

}

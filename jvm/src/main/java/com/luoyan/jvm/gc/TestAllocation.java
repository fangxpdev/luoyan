package com.luoyan.jvm.gc;

/**
 * JVM参数:-verbose:gc -Xms20M-Xmx20M-Xmn10M-XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+UseSerialGC
 *
 * 对象优先分配在eden区,不够先GC
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] a1 = new byte[2 * _1MB];
        byte[] a2 = new byte[2 * _1MB];
        byte[] a3 = new byte[2 * _1MB];
        byte[] a4 = new byte[4 * _1MB];

    }

}

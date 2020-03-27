package com.luoyan;

import org.apache.lucene.util.RamUsageEstimator;

public class ByteTest {

    public static void main(String[] args) {

        String s = "woaini";

        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);

        System.out.println(RamUsageEstimator.sizeOf(s));
        System.out.println(RamUsageEstimator.sizeOf(bytes));

        System.out.println(RamUsageEstimator.sizeOf(bytes));
    }

}

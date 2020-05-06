package com.luoyan.jvm;

public class NewInstanceTest {

    public static void main(String[] args) {

        Object object = new Object();
        t(object);

    }

    public static void t(Object o) {
        System.out.printf("0" + o);
    }

}

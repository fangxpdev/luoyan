package com.luoyan.jvm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class ClassLayoutTest {

    public static void main(String[] args) {
        Object object = new Object();
        System.out.printf("object : " + ClassLayout.parseInstance(object).toPrintable());


        synchronized (object) {
            System.out.printf("object : " + ClassLayout.parseInstance(object).toPrintable());
        }
    }

}

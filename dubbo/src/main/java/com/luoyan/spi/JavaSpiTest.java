package com.luoyan.spi;

import java.util.ServiceLoader;

public class JavaSpiTest {

    public static void main(String[] args) {

        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);

        System.out.println("java spi");


        serviceLoader.forEach(Robot::sayHello);

    }
}

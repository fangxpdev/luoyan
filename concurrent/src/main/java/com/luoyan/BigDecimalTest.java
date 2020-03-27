package com.luoyan;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal a1 = new BigDecimal(1);

        BigDecimal a2 = new BigDecimal(1.0);

        boolean equals = a1.equals(a2);
        System.out.println(equals);
        System.out.println(a1.compareTo(a2));

        BigDecimal a3 = new BigDecimal("1");

        BigDecimal a4 = new BigDecimal("1.0");

        System.out.println(a3.equals(a4));
        System.out.println(a3.compareTo(a4));

    }

}

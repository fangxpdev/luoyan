package com.luoyan.array;

/**
 * @author michael
 */
public class Fib509 {

    public static void main(String[] args) {

//        System.out.println(fb(0));s
//        System.out.println(fb(1));
//        System.out.println(fb(2));
//        System.out.println(fb(3));
//        System.out.println(fb(4));
//        System.out.println(fb(5));
        System.out.println(fb2(30));

    }


    public static int fb(int n) {
        if (n < 2) {
            return n;
        }
        return fb(n - 1) + fb(n - 2);
    }

    public static int fb2(int n) {
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}

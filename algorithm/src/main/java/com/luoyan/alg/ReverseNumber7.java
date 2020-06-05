package com.luoyan.alg;

public class ReverseNumber7 {

    public static void main(String[] args) {

//        System.out.println(reverse(1534236469));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE / 10);
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
        }

        return result;
    }


}

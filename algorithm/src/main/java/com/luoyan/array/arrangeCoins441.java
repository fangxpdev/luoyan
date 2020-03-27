package com.luoyan.array;

public class arrangeCoins441 {

    public static void main(String[] args) {
        System.out.println(arrangeCoins3(2));

    }

    /**
     * 等差数列求和公式：n(a1+an)/2
     * 时间太长
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {

        int sum = 0;
        int i = 0;
        while (sum <= n) {
            i++;
            sum += i;
        }
        return i - 1;
    }


    public static int arrangeCoins2(int n) {
        int res = 0;
        while (n >= res) {
            n -= res;
            res++;
        }
        return res -1;
    }

    public static int arrangeCoins3(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }


}

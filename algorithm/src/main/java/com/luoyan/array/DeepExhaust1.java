package com.luoyan.array;

public class DeepExhaust1 {

    static int n = 4;

    static int k = 13;

    static final int[] a = new int[]{1, 2, 4, 7};

    public static void main(String[] args) {
        boolean dfs = dfs(0, 0);
        System.out.println(dfs);

    }

    public static boolean dfs(int i, int sum) {
        if (i == n) {
            return sum == k;
        }

        //不加a[i]
        if (dfs(i + 1, sum)) {
            System.out.println("不加：" + a[i]);
            return true;
        }

        //加a[i]
        if (dfs(i + 1, sum + a[i])) {
            System.out.println("加：" + a[i]);
            return true;
        }
        return false;
    }

}

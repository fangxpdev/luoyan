package com.luoyan.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 5, 3, 8, 6, 9, 4};
        sort(nums, 0, nums.length - 1);
        ArrayUtils.printArray(nums);

    }


    static void sort(int[] arr, int left, int right) {

        if (left == right) {
            return;
    }
    int exchange = partition(arr, left, right);
        //左边
        sort(arr, left, exchange);
        //右边
        sort(arr, exchange + 1, right);
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = right;
        int exchangePosition = pivot - 1;

        for (int i = left; i <= right; i++) {

        }

        return exchangePosition;
    }

}

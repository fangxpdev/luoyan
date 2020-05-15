package com.luoyan.sort;

public class MergeSort {


    public static void main(String[] args) {

        int[] nums = new int[]{4, 1, 7, 8, 3, 6, 9,2};
        sort(nums, 0, nums.length - 1);
        ArrayUtils.printArray(nums);


    }

    static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        //左边排序
        sort(arr, left, mid);
        //右边排序
        sort(arr, mid + 1, right);

        //合并
        merge(arr, left, mid + 1, right);
    }

    static void merge(int[] arr, int left, int right, int rightBound) {
        int mid = right - 1;
        int[] nums = new int[rightBound - left + 1];

        int l = left, r = right, i = 0;
        while (l <= mid && r <= rightBound) {
            nums[i++] = arr[l] > arr[r] ? arr[r++] : arr[l++];
        }
        while (l <= mid) {
            nums[i++] = arr[l++];
        }
        while (r <= rightBound) {
            nums[i++] = arr[r++];
        }

        for (int j = left; j <= rightBound; j++) {
            arr[j] = nums[j - left];
        }
        ArrayUtils.printArray(nums);
    }

}

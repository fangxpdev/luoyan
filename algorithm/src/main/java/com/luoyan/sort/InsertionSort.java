package com.luoyan.sort;

/**
 * 插入排序
 * 时间复杂度 n^2
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 5, 3, 8, 6, 9, 4};
        sort(nums);
        ArrayUtils.printArray(nums);

    }

    static void sort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    ArrayUtils.swap(nums, j, j - 1);
                } else {
                    break;
                }

            }
        }
    }

    static void sort2(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                ArrayUtils.swap(nums, j, j - 1);
            }
        }
    }


}

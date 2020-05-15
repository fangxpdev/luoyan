package com.luoyan.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 3, 8, 6, 9, 4};
//        sort(nums, nums.length);
        sort2(nums);

        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    static void sort(int[] nums, int maxPosition) {

        boolean sorted = true;
        for (int i = 0; i < maxPosition - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                sorted = false;
                ArrayUtils.swap(nums, i, i + 1);
            }
        }
        if (maxPosition > 0 && !sorted) {
            sort(nums, --maxPosition);
        }

    }

    static void sort2(int[] nums) {

        for (int j = nums.length - 1; j > 0; j--) {
            boolean sorted = true;
            for (int i = 0; i < j; i++) {
                if (nums[i] > nums[i + 1]) {
                    sorted = false;
                    ArrayUtils.swap(nums, i, i + 1);
                }
            }
            if (sorted) {
                break;
            }
        }

    }


}

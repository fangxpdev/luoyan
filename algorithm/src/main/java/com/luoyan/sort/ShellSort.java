package com.luoyan.sort;

/**
 * shell排序
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 5, 3, 8, 6, 9, 4};

        sort(nums);
        ArrayUtils.printArray(nums);
    }

    static void sort(int[] nums) {
        //knuth 序列
        int h = 1;
        while (h <= nums.length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            //注意 i = i+1 不是i = i+gap
            for (int i = gap; i < nums.length; i += 1) {
                for (int j = i; j > 0; j -= gap) {
                    if (nums[j] < nums[j - gap]) {
                        ArrayUtils.swap(nums, j, j - gap);
                    } else {
                        break;
                    }
                }
            }
        }
    }

}

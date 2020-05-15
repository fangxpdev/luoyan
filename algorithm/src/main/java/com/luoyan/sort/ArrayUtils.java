package com.luoyan.sort;

public class ArrayUtils {

    /**
     * 交换
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void printArray(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < nums.length; i++) {
            builder.append(nums[i]);
            if (i != nums.length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        System.out.println(builder);
    }
}

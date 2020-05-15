package com.luoyan.sort;

public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 5, 3, 8, 6, 9, 4};
        sort(nums, 0);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }


    /**
     * 复杂度
     * n + (n-1) + .....+ 1
     * = n(n+1)/2 = n^2
     *
     * @param nums
     * @param index
     */
    public static void sort(int[] nums, int index) {
        int minIndex = index;

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }
        }
        int temp = nums[index];
        nums[index] = nums[minIndex];
        nums[minIndex] = temp;
        if (index < nums.length - 2) {
            sort(nums, ++index);
        }
    }


}

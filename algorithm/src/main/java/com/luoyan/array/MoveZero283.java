package com.luoyan.array;

public class MoveZero283 {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes3(nums);
        for (int num : nums) {
            System.out.print(num + ",");

        }
    }



    public static void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 交换
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }


    }


    public static void moveZeroes3(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }

    }
}

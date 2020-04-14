package com.luoyan.array;

import com.luoyan.util.PrintUtils;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 */
public class ArrayMerge88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);

    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 || n == 0) {
            return;
        }

        int[] newArray = new int[nums1.length];

        int k = 0, j = 0, i = 0;
        while (k < m && j < n) {
            if (nums1[k] > nums2[j]) {
                newArray[i++] = nums2[j++];
            } else {
                newArray[i++] = nums1[k++];
            }
        }
        while (k < m) {
            newArray[i++] = nums1[k++];
        }

        while (j < n) {
            newArray[i++] = nums2[j++];
        }

        System.arraycopy(newArray, 0, nums1, 0, newArray.length);
        PrintUtils.printArray(nums1);

    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge2(nums1, 2, nums2, 3);
        PrintUtils.printArray(nums1);

    }


}

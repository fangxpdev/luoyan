package com.luoyan.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{2, 1, 5, 3, 8, 6, 9, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * priorityQueue是小顶堆
     * 每次取根节点，为最小值
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {

        Queue<Integer> queue = new PriorityQueue<>(Arrays.asList(arr));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
    }

}

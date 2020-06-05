package com.luoyan.util;

import com.luoyan.ListNode;

public class PrintUtils {

    public static void printListNode(ListNode node) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode cur = node;
        while (cur != null) {
            builder.append(cur.val);
            builder.append(",");
            cur = cur.next;
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        System.out.println(builder.toString());
    }

    public static void printArray(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < nums.length; i++) {
            builder.append(nums[i] + ",");
        }

        builder.replace(builder.length() - 1, builder.length(), "]");
        System.out.println(builder.toString());

    }

}

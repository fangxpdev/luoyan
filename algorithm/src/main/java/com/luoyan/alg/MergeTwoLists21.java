package com.luoyan.alg;

import com.luoyan.ListNode;

public class MergeTwoLists21 {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
        }
        node.next = l1 == null ? l2 : l1;
        return head.next;
    }
}

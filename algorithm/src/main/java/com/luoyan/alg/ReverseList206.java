package com.luoyan.alg;

import com.luoyan.ListNode;

import java.util.List;

public class ReverseList206 {

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }

    public static void main(String[] args) {

        ListNode listNode = ListNode.of(5, 4, 3, 2, 1);
        System.out.println(listNode);
        ListNode node = reverseList(listNode);
        System.out.println(node);
    }
}

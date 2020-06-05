package com.luoyan.linkedlist;

import com.luoyan.ListNode;

public class removeNthFromEnd19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;

        int length = 0;
        ListNode first = dump;
        ListNode second = dump;

        while (first != null) {
            if (length > n) {
                second = second.next;
            }
            first = first.next;
            length++;
        }
        second.next = second.next.next;

        return dump.next;
    }

}

package com.luoyan.linkedlist;


import java.util.HashSet;
import java.util.Set;

public class HasCycle141 {


    /**
     * hash法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }


    public static boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;

    }


    public static void main(String[] args) {

        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        ListNode head = node3;
        node3.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;

        System.out.println(hasCycle2(head));




    }

}

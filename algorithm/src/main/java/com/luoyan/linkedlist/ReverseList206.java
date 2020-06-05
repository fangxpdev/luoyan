package com.luoyan.linkedlist;

import com.luoyan.ListNode;

public class ReverseList206 {

    /**
     * 创建新节点
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            node.next = res;
            res = node;
            cur = cur.next;
        }
        return res;
    }


    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode node = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(node.toString());

        ListNode reverseNode = reverseList(node);
        System.out.println(reverseNode.toString());
    }

}

package com.luoyan.linkedlist;

public class ListNode {

    public int val;

    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode cur = this;
        while (cur != null) {
            builder.append(cur.val);
            builder.append(",");
            cur = cur.next;
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    public static ListNode of(int... values) {
        ListNode head = null;
        ListNode node;
        for (int value : values) {
            node = new ListNode(value);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode prev = node;

        prev.next = new ListNode(2);

        System.out.println(node.toString());
    }

}

package com.luoyan.linkedlist;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class DetectCycle142 {


    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        slow = head;

        while (slow != fast) {

            slow = slow.next;
            fast = fast.next;
        }


        return fast;
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

        ListNode node = detectCycle(head);
        System.out.println(node.val);
    }

}

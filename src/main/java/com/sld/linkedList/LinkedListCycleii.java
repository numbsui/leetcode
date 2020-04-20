package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 142
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleii {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;

        ListNode node = detectCycle(head);
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("无环");
        }
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                ListNode node = head;
                while (p1 != node) {
                    p1 = p1.next;
                    node = node.next;
                }
                return node;
            }
        }
        return null;
    }
}

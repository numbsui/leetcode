package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 148
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        ListNode node = sortList(head);
        System.out.println(node);
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = sortList(slow.next);
        slow.next = null;

        ListNode l1 = sortList(head);

        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        p.next = (l1 == null ? l2 : l1);
        return l.next;
    }
}

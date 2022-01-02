package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 148
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * <p>
     * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(7);
        ListNode l7 = new ListNode(8);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        ListNode node = sortList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
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

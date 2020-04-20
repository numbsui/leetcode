package com.sld.linkedList;

/**
 * @author sld
 *
 * leetcode 21
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);

        head.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode head2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l32 = new ListNode(4);

        head2.next = l22;
        l22.next = l32;
        l32.next = null;

        ListNode node = mergeTwoLists2(head, head2);
        System.out.println(node);
    }

    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode tmp = new ListNode(-1);

        ListNode l3 = tmp;
        while (l1 !=null && l2 != null) {
            if (l1.val <= l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        l3.next = l1 == null ? l2 : l1;
        return tmp.next;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

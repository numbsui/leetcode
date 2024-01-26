package com.sld.linkedList;

/**
 * @author sld
 *
 * leetcode 21
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
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

        ListNode node = mergeTwoLists4(head, head2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    private static ListNode mergeTwoLists4(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                dummy.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        if (list1 != null) dummy.next = list1;
        if (list2 != null) dummy.next = list2;
        return result.next;
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

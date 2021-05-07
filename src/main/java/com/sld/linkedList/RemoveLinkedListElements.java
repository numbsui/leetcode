package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 203
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        int val = 6;

        ListNode node = removeElements(head, val);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode cur = head;
        ListNode pre = tmp;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return tmp.next;
    }
}

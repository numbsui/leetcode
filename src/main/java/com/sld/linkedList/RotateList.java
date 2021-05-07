package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 61
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {

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
        l5.next = null;

        int k = 2;

        /*ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);

        head.next = l2;
        l2.next = null;

        int k = 1;*/

        ListNode node = rotateRight(head, k);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /*
    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]
     */
    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        ListNode tmpNode = head;

        int len = 1;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            len++;
        }
        tmpNode.next = head;

        for (int i = len - k % len; i > 1; i--) {
            head = head.next;
        }

        tmpNode = head.next;
        head.next = null;

        return tmpNode;
    }
}

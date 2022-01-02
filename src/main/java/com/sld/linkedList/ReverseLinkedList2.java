package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 92
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList2 {

    /**
     * 给你单链表的头指针head和两个整数left和right，其中left <= right。请你反转从位置left到位置right的链表节点，返回反转后的链表 。
     */
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

        int left = 2, right = 4;

        ListNode node = reverseBetween(head, left, right);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    //1 2 3 4 5      2-4    2 3 4
    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next; //1
        }
        ListNode cur = pre.next; //2
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next; //2-4
            next.next = pre.next;  //3-2
            pre.next = next; //1-3
        }
        return dummy.next;

    }

}

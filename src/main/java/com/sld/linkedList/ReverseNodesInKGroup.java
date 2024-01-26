package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 25
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

    /**
     * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。k是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 进阶：
     *    你可以设计一个只使用常数额外空间的算法来解决此问题吗？
     *    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
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

        ListNode node = reverseKGroup(head, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && k != count) {
            cur = cur.next;
            count++;
        }

        if (k == count) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

}

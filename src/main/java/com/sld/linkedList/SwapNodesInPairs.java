package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 24
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

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

        ListNode node = swapPairs(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {

        ListNode tmpNode = new ListNode(0);
        tmpNode.next = head;

        ListNode p = tmpNode;
        while (p.next != null && p.next.next != null) {
            ListNode n1 = p.next;
            ListNode n2 = n1.next;
            ListNode next = n2.next;

            n2.next = n1;
            n1.next = next;
            p.next = n2;
            p = n1;
        }

        return tmpNode.next;
    }
}

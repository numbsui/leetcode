package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 25
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

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

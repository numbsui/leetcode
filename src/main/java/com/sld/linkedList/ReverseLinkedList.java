package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 206
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        ListNode node = reverseList3(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    /**
     * 递归法
     */
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 如： 1-2-3-4-null
     * head节点在1，将tmpNode指向1，1与2之间截断，head指向2，变成tmpNode-1-null， 2-3-4-null
     * 以此类推，最后得到 tmpNode-4-3-2-1-null，将head指向tmpNode下一个节点，tmpNode指向空，完成reverse
     */
    private static ListNode reverseList(ListNode head) {
        // 辅助结点
        ListNode tmpNode = new ListNode(0);
        ListNode nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = tmpNode.next;
            tmpNode.next = head;
            head = nextNode;
        }

        head = tmpNode.next;
        tmpNode.next = null;

        return head;
    }

    private static ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

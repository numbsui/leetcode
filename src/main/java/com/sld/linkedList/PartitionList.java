package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 86
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在
     * 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        int x = 3;
        ListNode node = partition(head, x);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    //两个链表，第一个存储小于x的节点，第二个存储大于x的节点，遍历完成后，将两个链表合并
    //1 4 3 2 5 2     1,2,2,4,3,5
    private static ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l1head = l1;
        ListNode l2 = new ListNode(0);
        ListNode l2head = l2;

        while (head != null) {
            if (head.val < x) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }

        l2.next = null;
        l1.next = l2head.next;
        return l1head.next;
    }

}

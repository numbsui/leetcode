package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 328
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * <p>
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
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

        ListNode node = oddEvenList(head);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    //1 2 3 4 5    1 3 5 2 4
    private static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}

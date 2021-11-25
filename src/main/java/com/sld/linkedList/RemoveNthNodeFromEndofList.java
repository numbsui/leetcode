package com.sld.linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sld
 * <p>
 * leetcode 19
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        /*ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);*/

        head.next = null;
        /*l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;*/

        int n = 1;
        ListNode node = removeNthFromEnd3(head, n);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    //方法一： 遍历得到长度，在循环删除对应的节点
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;

        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }

        int index = length - n;
        int curIndex = 0;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode cur = head;
        ListNode pre = dumpy;
        while (cur != null) {
            if (curIndex == index) {
                pre.next = cur.next;
                break;
            } else {
                pre = pre.next;
            }
            curIndex++;
            cur = cur.next;
        }
        return dumpy.next;
    }

    //方法二： 利用栈  先进后出
    private static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;

        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dumpy.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode node = stack.peek();
        if (node != null)
            node.next = node.next.next;
        else
            head = head.next;
        return head;
    }

    /**
     * 我们也可以在不预处理出链表的长度，以及使用常数空间的前提下解决本题。
     * <p>
     * 由于我们需要找到倒数第 n 个节点，因此我们可以使用两个指针 first 和 second 同时对链表进行遍历，并且 first 比 second 超前 n 个节点。
     * 当 first 遍历到链表的末尾时，second 就恰好处于倒数第 n 个节点。
     * <p>
     * 具体地，初始时 first 和 second 均指向头节点。我们首先使用first 对链表进行遍历，遍历的次数为 n。此时，first 和second 之间间隔了 n−1 个节点，
     * 即 first 比 second 超前了 n 个节点。
     * <p>
     * 在这之后，我们同时使用 first 和second 对链表进行遍历。当first 遍历到链表的末尾（即 first 为空指针）时，second 恰好指向倒数第 n 个节点。
     * <p>
     * 根据方法一和方法二，如果我们能够得到的是倒数第 n 个节点的前驱节点而不是倒数第 n 个节点的话，删除操作会更加方便。因此我们可以考虑在初始时将
     * second 指向哑节点，其余的操作步骤不变。这样一来，当 first 遍历到链表的末尾时，second 的下一个节点就是我们需要删除的节点。
     */
    private static ListNode removeNthFromEnd3(ListNode head, int n) {

        ListNode first = head;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode second = dumpy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dumpy.next;
    }
}

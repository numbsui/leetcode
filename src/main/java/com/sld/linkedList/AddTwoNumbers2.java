package com.sld.linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sld
 * <p>
 * leetcode 445
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers2 {

    /**
     * 给你两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l1.next = l12;
        l12.next = l13;
        l13.next = null;

        l2.next = l22;
        l22.next = l23;
        l23.next = null;

        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    //443 + 564   1007
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode result = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = result;
            result = cur;
        }
        return result;
    }
}

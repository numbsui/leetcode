package com.sld.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sld
 * <p>
 * leetcode 141
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

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

        System.out.println(hasCycle2(head));
    }

    //方法一：使用集合存储记录，遍历链表，若集合中有记录，则有环  O(n)
    private static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    //方法二：快慢指针  O(n)
    private static boolean hasCycle2(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

}

package com.sld.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 143
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * <p>
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     * <p>
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        node.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        reorderList2(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode tmpNode = head;
        while (tmpNode != null) {
            list.add(tmpNode);
            tmpNode = tmpNode.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j)
                break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * 注意到目标链表即为将原链表的左半端和反转后的右半端合并后的结果。
     * <p>
     * 这样我们的任务即可划分为三步：
     * <p>
     * 找到原链表的中点（参考「876. 链表的中间结点」）。
     * <p>
     * 我们可以使用快慢指针来 O(N) 地找到链表的中间节点。
     * 将原链表的右半端反转（参考「206. 反转链表」）。
     * <p>
     * 我们可以使用迭代法实现链表的反转。
     * 将原链表的两端合并。
     * <p>
     * 因为两链表长度相差不超过 1，因此直接合并即可。
     */
    public static void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}



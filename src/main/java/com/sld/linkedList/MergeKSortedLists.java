package com.sld.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sld
 * <p>
 * leetcode 23
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);

        head.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode head2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l32 = new ListNode(4);

        head2.next = l22;
        l22.next = l32;
        l32.next = null;

        ListNode head3 = new ListNode(2);
        ListNode l33 = new ListNode(6);
        head3.next = l33;
        l33.next = null;

        ListNode[] lists = {head, head2, head3};

        ListNode node = mergeKLists3(lists);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    //方法一： 遍历，每两个合并
    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode listNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            listNode = mergeTwoList(listNode, lists[i]);
        }
        return listNode;
    }

    //方法二： 分治
    private static ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    //方法二： 优先级队列
    private static ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode s = pq.poll();
            cur.next = s;
            cur = cur.next;
            s = s.next;
            if (s != null) {
                pq.offer(s);
            }
        }
        return dummy.next;
    }

    private static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private static ListNode mergeTwoList(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) return listNode2;
        if (listNode2 == null) return listNode1;
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                dummy.next = new ListNode(listNode1.val);
                listNode1 = listNode1.next;
            } else {
                dummy.next = new ListNode(listNode2.val);
                listNode2 = listNode2.next;
            }
            dummy = dummy.next;
        }
        if (listNode1 != null) dummy.next = listNode1;
        if (listNode2 != null) dummy.next = listNode2;
        return result.next;
    }
}

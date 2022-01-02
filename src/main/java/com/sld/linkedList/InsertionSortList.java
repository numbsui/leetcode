package com.sld.linkedList;

/**
 * @author sld
 * <p>
 * leetcode 147
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    /**
     * 对链表进行插入排序。
     * <p>
     * 插入排序算法：
     * <p>
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        ListNode node = insertionSortList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    //4 2 1 3
    private static ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lastSorted = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val > lastSorted.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                lastSorted.next = cur.next; //lastSorted:4213  cur:213  after: lastSorted:413  cur:213 pre:0413
                cur.next = pre.next;  //after:  cur:2413  pre:0413
                pre.next = cur;     //after: cur:2413  lastSorted:413
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}

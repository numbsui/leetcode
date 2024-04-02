package com.sld.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 230
 * 相关：98 501 530 783 173 230
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementinaBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        TreeNode left2 = left.left = new TreeNode(2);
        left.right = new TreeNode(4);

        left2.left = new TreeNode(1);

        int k = 3;
        System.out.println(kthSmallest2(root, k));
    }

    //方法一：中序遍历（递归）
    private static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        func(root, list);
        return list.get(k - 1);
    }

    private static void func(TreeNode node, List<Integer> list) {
        if (node == null) return;
        func(node.left, list);
        list.add(node.val);
        func(node.right, list);
    }

    //方法二：中序遍历，利用栈
    private static int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

}

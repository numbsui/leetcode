package com.sld.tree;

import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 99
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(3);
        left.right = new TreeNode(2);
        recoverTree2(root);
        System.out.println(root);
    }

    //mirrors遍历
    private static void recoverTree2(TreeNode root) {
        TreeNode node = null;
        TreeNode pre = null;
        TreeNode x = null;
        TreeNode y = null;

        while(root != null) {
            if (root.left != null) {
                node = root.left;
                while (node.right != null && node.right != root) {
                    node = node.right;
                }

                if (node.right == null) {
                    node.right = root;
                    root = root.left;
                } else {
                    if (pre != null && root.val < pre.val) {
                        y = root;
                        if (x == null) x = pre;
                    }
                    pre = root;
                    node.right = null;
                    root = root.right;
                }
            } else {
                if (pre != null && root.val < pre.val) {
                    y = root;
                    if (x == null) x = pre;
                }
                pre = root;
                root = root.right;
            }
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    private static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode swap1 = null;
        TreeNode swap2 = null;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val >= cur.val) {
                if (swap1 == null) {
                    swap1 = pre;
                }
                swap2 = cur;
            }
            pre = cur;
            cur = cur.right;
        }

        int tmp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = tmp;
    }
}

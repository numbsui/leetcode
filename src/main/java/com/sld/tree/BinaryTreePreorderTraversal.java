package com.sld.tree;

import java.util.*;

/**
 * @author sld
 *
 * leetcode 144
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

    /**
     * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = root.left = new TreeNode(5);
        TreeNode right = root.right = new TreeNode(1);

        left.left = new TreeNode(6);
        TreeNode right2 = left.right = new TreeNode(2);
        right2.left = new TreeNode(7);
        TreeNode right3 = right2.right = new TreeNode(4);

        right.left = new TreeNode(0);
        right.right = new TreeNode(8);
        System.out.println(preorderTraversal2(root));
    }

    //方法一：递归
    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    //方法二：非递归，使用stack实现
    private static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }

}

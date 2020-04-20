package com.sld.tree;

import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 226
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(7);

        //left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);

        TreeNode node = invertTree(root);
        System.out.println(node);
    }

    private static TreeNode invertTree2(TreeNode root) {

        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tmpNode;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            tmpNode = node.left;
            node.left = node.right;
            node.right = tmpNode;
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }

    private static TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}

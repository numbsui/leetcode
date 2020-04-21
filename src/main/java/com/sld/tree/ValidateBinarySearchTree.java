package com.sld.tree;

import java.util.Stack;

/**
 * @author sld
 *
 * leetcode 98
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = root.left = new TreeNode(1);
        TreeNode right = root.right = new TreeNode(6);

        right.left = new TreeNode(3);
        right.right = new TreeNode(8);
        System.out.println(isValidBST2(root));
    }

    //方法一：使用变量保存最大值和最小值，递归遍历
    private static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    //方法二：中序遍历二叉树，有序则是BST
    private static boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}

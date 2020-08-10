package com.sld.tree;

/**
 * @author sld
 *
 * leetcode 110
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = root.left = new TreeNode(9);
        TreeNode right = root.right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        System.out.println(height(root));
        System.out.println(isBalanced(root));
    }

    //方法一：自顶向下的递归，时间复杂度 O(nlogn)
    private static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

    //计算树高
    private static int height(TreeNode node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    //方法二：自底向上，递归，时间复杂度 O(n)
    private static boolean isBalanced2(TreeNode root) {
        return helper(root) != -1;
    }

    private static int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        if (left == -1) return -1;
        int right = helper(node.right);
        if (right == -1) return -1;

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

}

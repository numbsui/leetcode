package com.sld.tree;

/**
 * @author sld
 * <p>
 * leetcode 530 783
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceinBST {

    private static int min = Integer.MAX_VALUE;
    private static TreeNode pre;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);

        TreeNode right = new TreeNode(15);
        root.right = right;

        right.left = new TreeNode(9);
        right.right = new TreeNode(20);

        System.out.println(getMinimumDifference(root));
    }

    private static int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (pre != null)
            min = Math.min(min, node.val - pre.val);
        pre = node;
        inOrder(node.right);
    }
}


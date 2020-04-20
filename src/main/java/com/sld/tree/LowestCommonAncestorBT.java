package com.sld.tree;

/**
 * @author sld
 *
 * leetcode 236
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorBT {

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
        System.out.println(lowestCommonAncestor(root, left, right3).val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

}

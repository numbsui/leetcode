package com.sld.tree;

/**
 * @author sld
 * <p>
 * leetcode 543
 * https://leetcode.com/problems/diameter-of-binary-tree/submissions/
 */
public class DiameterofBinaryTree {

    private static int result;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        dfs(root);
        return result - 1;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }

}

package com.sld.tree;

/**
 * @author sld
 * <p>
 * leetcode 129
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRoottoLeafNumbers {

    private static int result = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(5);

        left.left = new TreeNode(3);
        left.right = new TreeNode(4);

        right.right = new TreeNode(6);
        System.out.println(sumNumbers(root));
    }

    //123 124 156
    private static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private static void dfs(TreeNode node, int temp) {
        if (node == null) return;
        temp = temp * 10 + node.val;
        if (node.left == null && node.right == null)
            result += temp;
        dfs(node.left, temp);
        dfs(node.right, temp);
    }
}

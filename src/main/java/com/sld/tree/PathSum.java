package com.sld.tree;

import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 112
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = root.left = new TreeNode(4);
        TreeNode right = root.right = new TreeNode(8);

        TreeNode left1 = left.left = new TreeNode(11);
        left1.left = new TreeNode(7);
        left1.right = new TreeNode(2);

        right.left = new TreeNode(13);

        TreeNode right1 = right.right = new TreeNode(4);
        right1.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }

    //方法二：stack
    private static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                if (node.val == sum)
                    return true;
            }
            if (node.right != null) {
                node.right.val += node.val;
                stack.push(node.right);
            }
            if (node.left != null) {
                node.left.val += node.val;
                stack.push(node.left);
            }
        }
        return false;
    }

    //方法一：dfs
    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

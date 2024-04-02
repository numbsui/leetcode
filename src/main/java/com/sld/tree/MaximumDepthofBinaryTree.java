package com.sld.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author sld
 * <p>
 * leetcode 104
 * 相关 102 1162 103 104 199 515 637
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = root.left = new TreeNode(9);
        TreeNode right = root.right = new TreeNode(20);

        left.left = new TreeNode(2);
        left.left.left = new TreeNode(1);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    //BFS
    private static int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }

    //DFS
    private static int maxDepth2(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth2(node.left), maxDepth2(node.right)) + 1;
    }
}

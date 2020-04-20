package com.sld.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sld
 *
 * leetcode 104
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
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while (!queue.isEmpty()) {
            max ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return max;
    }

    //DFS
    private static int maxDepth2(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth2(node.left), maxDepth2(node.right)) + 1;
    }
}

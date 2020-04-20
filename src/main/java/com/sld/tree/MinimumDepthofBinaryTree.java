package com.sld.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sld
 *
 * leetcode 111
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = root.left = new TreeNode(9);
        TreeNode right = root.right = new TreeNode(20);

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }

    //BFS
    private static int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return min;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            min ++;
        }
        return min;
    }

    //DFS
    private static int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}

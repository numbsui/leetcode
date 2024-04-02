package com.sld.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author sld
 * <p>
 * leetcode 515
 * 相关 102 1162 103 104 199 515 637
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(3);
        TreeNode right = root.right = new TreeNode(2);

        left.left = new TreeNode(5);
        left.right = new TreeNode(3);
        right.right = new TreeNode(9);
        System.out.println(largestValues(root));
    }

    private static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}

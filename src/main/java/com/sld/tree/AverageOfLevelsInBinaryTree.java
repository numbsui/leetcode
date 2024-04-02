package com.sld.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author sld
 * <p>
 * leetcode 637
 * 相关 102 1162 103 104 199 515 637
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = root.right = new TreeNode(20);

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        System.out.println(averageOfLevels(root));
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }
}

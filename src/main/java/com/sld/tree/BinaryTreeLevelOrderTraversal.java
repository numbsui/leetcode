package com.sld.tree;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 102
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = root.left = new TreeNode(9);
        TreeNode right = root.right = new TreeNode(20);

        left.left = new TreeNode(2);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        System.out.println(levelOrder2(root));
    }

    //BFS
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                if (node != null)
                    currentLevel.add(node.val);
                else node = new TreeNode(0);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(currentLevel);
        }

        return result;
    }

    //DFS
    private static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}

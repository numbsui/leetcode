package com.sld.tree;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 513
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(3);
        left.left = new TreeNode(4);

        TreeNode left2 = right.left = new TreeNode(5);
        right.right = new TreeNode(6);

        left2.left = new TreeNode(7);
        System.out.println(findBottomLeftValue2(root));
    }

    //方法一：dfs
    private static int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        return result.get(result.size() - 1).get(0);
    }

    private static void dfs(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) return;
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        dfs(node.left, list, level + 1);
        dfs(node.right, list, level + 1);
    }

    //方法二：队列
    private static int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
            result = node.val;
        }
        return result;
    }
}

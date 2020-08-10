package com.sld.tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sld
 *
 * leetcode 257
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(3);
        left.right = new TreeNode(5);

        System.out.println(binaryTreePaths(root));
    }

    //方法一：bfs
    private static List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Pair<TreeNode, String>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, ""));

        while (!queue.isEmpty()) {
            Pair<TreeNode, String> pair = queue.poll();
            TreeNode node = pair.getKey();
            String s = pair.getValue();

            if (node.left == null && node.right == null) {
                s += node.val;
                result.add(s);
            }

            if (node.left != null) {
                queue.add(new Pair<>(node.left, s + node.val + "->"));
            }

            if (node.right != null) {
                queue.add(new Pair<>(node.right, s + node.val + "->"));
            }
        }

        return result;
    }


    //方法二：dfs
    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }

    private static void dfs(TreeNode node, String s, List<String> list) {
        s += node.val + " ";

        if (node.left == null && node.right == null)
            list.add(s.trim().replace(" ", "->"));

        if (node.left != null)
            dfs(node.left, s, list);

        if (node.right != null)
            dfs(node.right, s, list);
    }
}

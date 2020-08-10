package com.sld.tree;

import java.util.*;

/**
 * @author suilindong
 * <p>
 * leetcode 623
 * https://leetcode.com/problems/add-one-row-to-tree/
 */
public class AddOneRowToTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        root.left = left;

        left.left = new TreeNode(3);
        left.right = new TreeNode(1);


        int v = 1;
        int d = 3;
        System.out.println(inorderTraversal(root));
        root = addOneRow(root, v, d);
        System.out.println(inorderTraversal(root));

    }


    private static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level == d - 1) {
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);
                    left.left = node.left;
                    node.left = left;

                    right.right = node.right;
                    node.right = right;
                } else {
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            level++;
        }
        return root;
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}

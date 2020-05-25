package com.sld.tree;

import java.util.ArrayList;

/**
 * @author sld
 * <p>
 * leetcode 114
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(5);

        left.left = new TreeNode(3);
        left.right = new TreeNode(4);

        right.right = new TreeNode(6);
        flatten(root);
        System.out.println(root);
    }

    // 左右分为两部分 1 2， 左子树拼接到右边， 右子树拼接到左子树，循环
    private static void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode node = root.left;
                //找到左子树最右节点
                while (node.right != null) {
                    node = node.right;
                }
                //右子树拼接到左子树最右节点
                node.right = root.right;
                //左子树移动到跟节点右边
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    private static void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(null);
        helper(root, list);
    }

    private static void helper(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null)
            return;
        TreeNode right = root.right;
        if (list.get(0) != null) {
            list.get(0).left = null;
            list.get(0).right = root;
        }
        list.set(0, root);
        helper(root.left, list);
        helper(right, list);
    }

}

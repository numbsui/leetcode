package com.sld.tree;

import java.util.*;

/**
 * @author sld
 *
 * leetcode 94
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    /**
     * 给定一个二叉树的根节点 root ，返回它的中序遍历。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = root.left = new TreeNode(5);
        TreeNode right = root.right = new TreeNode(1);

        left.left = new TreeNode(6);
        TreeNode right2 = left.right = new TreeNode(2);
        right2.left = new TreeNode(7);
        TreeNode right3 = right2.right = new TreeNode(4);

        right.left = new TreeNode(0);
        right.right = new TreeNode(8);

        System.out.println(inorderTraversal2(root));
    }

    //方法一 ：递归
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

    //方法二：非递归，使用stack实现
    private static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

}

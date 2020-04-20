package com.sld.tree;

import java.util.*;

/**
 * @author sld
 *
 * leetcode 145
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

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
        System.out.println(postorderTraversal2(root));
    }

    //递归
    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    //非递归，使用stack实现
    private static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }

}

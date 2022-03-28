package com.sld.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sld
 * <p>
 * leetcode 103
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(3);

        left.left = new TreeNode(4);
        right.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(root));
    }

    //[1,2,3,4,null,null,5]
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();

        boolean flag = true;
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (!flag)
                        deque.addFirst(node.val);
                    else
                        deque.addLast(node.val);
                } else {
                    node = new TreeNode(0);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(new LinkedList<>(deque));
            flag = !flag;
        }
        return result;
    }
}


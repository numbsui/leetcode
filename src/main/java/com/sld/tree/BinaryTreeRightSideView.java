package com.sld.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sld
 * <p>
 * leetcode 199
 * 相关 102 1162 103 104 199 515 637
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {

    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(3);

        left.right = new TreeNode(5);
        right.right = new TreeNode(4);
        System.out.println(rightSideView(root));
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cur = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < cur; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list.get(list.size() - 1));
        }
        return result;
    }
}

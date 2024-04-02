package com.sld.tree;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 103
 * 相关 102 1162 103 104 199 515 637
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
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return new ArrayList<>();
        boolean flag = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> cur = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    cur.add(node.val);
                } else {
                    cur.addFirst(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(new LinkedList<>(cur));
            flag = !flag;
        }
        return result;
    }


}


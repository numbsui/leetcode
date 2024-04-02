package com.sld.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sld
 * <p>
 * leetcode 101
 * https://leetcode.cn/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q1 = p.left = new TreeNode(2);
        TreeNode q2 = p.right = new TreeNode(3);

        q1.left = new TreeNode(3);
        q1.right = new TreeNode(4);
        q2.left = new TreeNode(4);
        q2.right = new TreeNode(3);
        System.out.println(isSymmetric2(p));
    }

    //迭代
    private static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }


    //递归
    private static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

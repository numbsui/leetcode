package com.sld.tree;

import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 617
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode left1 = t1.left = new TreeNode(3);
        TreeNode right1 = t1.right = new TreeNode(2);
        left1.left = new TreeNode(5);


        TreeNode t2 = new TreeNode(2);
        TreeNode left2 = t2.left = new TreeNode(1);
        TreeNode right2 = t2.right = new TreeNode(3);
        left2.right = new TreeNode(4);
        right2.right = new TreeNode(7);
        System.out.println(mergeTrees(t1, t2));
    }

    //方法一：前序（或 中 后）遍历两棵树，将第二棵树节点的值加到第一棵树
    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.val += t2.val;
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    //方法二：迭代
    private static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            if (nodes[0] == null || nodes[1] == null) {
                continue;
            }
            nodes[0].val += nodes[1].val;
            if (nodes[0].left == null) {
                nodes[0].left = nodes[1].left;
            } else {
                stack.push(new TreeNode[]{nodes[0].left, nodes[1].left});
            }

            if (nodes[0].right == null) {
                nodes[0].right = nodes[1].right;
            } else {
                stack.push(new TreeNode[]{nodes[0].right, nodes[1].right});
            }
        }
        return t1;
    }
}

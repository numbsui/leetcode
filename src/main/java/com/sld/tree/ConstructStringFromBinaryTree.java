package com.sld.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author sld
 *
 * leetcode 606
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        left.right = new TreeNode(4);
        System.out.println(tree2str2(root));
    }

    //方法一：递归
    private static String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return t.val + "";
        if (t.right == null) return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    //方法二：非递归，使用stack实现
    private static String tree2str2(TreeNode t) {
        if (t == null) return "";
        String str;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(t);
        StringBuilder strBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (set.contains(node)) {
                stack.pop();
                strBuilder.append(")");
            } else {
                set.add(node);
                strBuilder.append("(").append(node.val);
                if (node.left == null && node.right != null)
                    strBuilder.append("()");
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
        str = strBuilder.toString();

        return str.substring(1, str.length() - 1);
    }
}

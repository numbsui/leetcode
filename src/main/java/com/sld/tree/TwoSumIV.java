package com.sld.tree;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 653
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIV {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        System.out.println(findTarget(root, 6));
    }

    private static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (set.contains(k - node.val))
                return true;
            set.add(node.val);
            node = node.right;
        }
        return false;
    }

}

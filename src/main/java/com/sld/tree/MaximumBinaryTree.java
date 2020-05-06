package com.sld.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sld
 * <p>
 * leetcode 654
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        System.out.println(constructMaximumBinaryTree2(nums));
    }

    //给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
    //
    //二叉树的根是数组中的最大元素。
    //左子树是通过数组中最大值左边部分构造出的最大二叉树。
    //右子树是通过数组中最大值右边部分构造出的最大二叉树。

    //通过给定的数组构建最大二叉树，并且输出这个树的根节点。

    //方法一：找出最大值，递归 O(n2)
    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private static TreeNode construct(int[] nums, int l, int r) {
        if (l == r) return null;
        int max = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums, l, max);
        root.right = construct(nums, max + 1, r);
        return root;
    }

    private static int findMax(int nums[], int l, int r) {
        int max = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }

    //方法二：使用栈，时间复杂度O(n)
    private static TreeNode constructMaximumBinaryTree2(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < num)
                node.left = stack.pop();

            if (!stack.isEmpty())
                stack.peek().right = node;
            stack.push(node);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}


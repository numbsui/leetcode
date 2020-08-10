package com.sld.tree;

/**
 * @author sld
 * <p>
 * leetcode 108
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(nums));
    }

    //将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
    private static TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    private static TreeNode helper(int start, int end, int[] nums) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(start, mid - 1, nums);
        root.right = helper(mid + 1, end, nums);
        return root;
    }
}


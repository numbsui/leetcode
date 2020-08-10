package com.sld.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 95
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> list = generateTrees(n);
        for (TreeNode node : list)
            System.out.println(node);
    }

    private static List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        return helper(1, n);
    }

    //1 2 3
    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (end < start) {
            result.add(null);
            return result;
        }
        //start 1  end 3     i 2
        for (int i = start; i <= end; i++) {
            for (TreeNode left : helper(start, i - 1)) {
                for (TreeNode right : helper(i + 1, end)) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}

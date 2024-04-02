package com.sld.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 783
 * 相关：98 501 530 783 173 230
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);

        TreeNode right = root.right = new TreeNode(48);
        right.left = new TreeNode(12);
        right.right = new TreeNode(49);

        System.out.println(minDiffInBST(root));
    }

    private static int minDiffInBST(TreeNode root) {
        int result = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);

        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff < result) {
                result = diff;
            }
        }
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }


}

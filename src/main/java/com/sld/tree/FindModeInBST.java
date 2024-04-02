package com.sld.tree;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 501
 * 相关：98 501 530 783 173 230
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 */
public class FindModeInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode right = root.right = new TreeNode(2);
        right.left = new TreeNode(2);

        System.out.println(Arrays.toString(findMode(root)));
    }

    private static int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        loop(root, map);

        int maxValue = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            Integer key = m.getKey();
            Integer value = m.getValue();
            if (value > maxValue) {
                maxValue = value;
                list.clear();
                list.add(key);
            } else if (value == maxValue) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static void loop(TreeNode node, Map<Integer, Integer> map) {
        if (node != null) {
            map.merge(node.val, 1, Integer::sum);
            loop(node.left, map);
            loop(node.right, map);
        }
    }
}

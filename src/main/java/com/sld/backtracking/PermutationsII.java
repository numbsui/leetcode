package com.sld.backtracking;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 47
 * 相关：46 78 90
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 1};
        System.out.println(permuteUnique2(nums));
    }


    //方法二： 回溯 剪枝
    private static List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        recursion2(nums, 0, visit, deque, result);
        return result;
    }

    private static void recursion2(int[] nums, int index, boolean[] visit, Deque<Integer> deque, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                continue;
            }

            deque.addLast(nums[i]);
            visit[i] = true;
            recursion2(nums, index + 1, visit, deque, result);
            visit[i] = false;
            deque.removeLast();
        }
    }

    //方法一：
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(nums, 0, result);
        return result;
    }

    private static void recursion(int[] num, int start, List<List<Integer>> result) {
        if (start == num.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i : num)
                list.add(i);
            if (!result.contains(list))
                result.add(list);
        }

        for (int i = start; i < num.length; i++) {
            if (i == start || num[i] != num[start]) {
                swap(num, i, start);
                recursion(num, start + 1, result);
                swap(num, i, start);
            }
        }
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}

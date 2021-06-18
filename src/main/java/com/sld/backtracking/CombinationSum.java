package com.sld.backtracking;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 39
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> combin = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(result, combin, 0, candidates.length, candidates, target);
        return result;
    }

    private static void dfs(List<List<Integer>> result, Deque<Integer> combin, int begin, int length, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(combin));
            return;
        }

        for (int i = begin; i < length; i++) {
            if (target - candidates[i] < 0)
                break;
            combin.addLast(candidates[i]);
            dfs(result, combin, i, length, candidates, target - candidates[i]);
            combin.removeLast();
        }
    }
}

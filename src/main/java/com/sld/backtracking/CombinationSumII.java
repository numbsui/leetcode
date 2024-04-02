package com.sld.backtracking;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 40
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        //1 1 2 5 6 7 10
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

        //1 1 2 5 6 7 10
        for (int i = begin; i < length; i++) {
            //对于1 2 2 2 5  会出现1 2(第一个2) 2,还会出现1 2(第二个2) 2的情况,下边判断去除这种重复
            if (i > begin && candidates[i] == candidates[i - 1])
                continue;
            //剪枝 大于target之后直接break,因为已经排序,下一个数一定也大于target
            if (target - candidates[i] < 0)
                break;
            combin.addLast(candidates[i]);
            dfs(result, combin, i + 1, length, candidates, target - candidates[i]);
            combin.removeLast();
        }
    }
}

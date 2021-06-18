package com.sld.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 216
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k, n));
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> combin = new ArrayDeque<>();
        dfs(result, combin, 1, k, n);
        return result;
    }

    private static void dfs(List<List<Integer>> result, Deque<Integer> combin, int begin, int k, int n) {
        if (combin.size() > k)
            return;

        if (combin.size() == k && n == 0) {
            result.add(new ArrayList<>(combin));
            return;
        }

        for (int i = begin; i <= 9; i++) {
            if (n - i >= 0) {
                combin.addLast(i);
                dfs(result, combin, i + 1, k, n - i);
                combin.removeLast();
            }
        }
    }
}

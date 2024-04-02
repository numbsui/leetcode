package com.sld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 77
 * https://leetcode.cn/problems/combinations/
 */
public class Combinations {

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine2(n, k));
    }

    private List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return result;
    }


    private void dfs(int index, int n, int k) {
        if (list.size() + n - index + 1 < k) {
            return;
        }

        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(index);
        dfs(index + 1, n, k);
        list.remove(list.size() - 1);
        dfs(index + 1, n, k);
    }


    private List<List<Integer>> combine2(int n, int k) {
        dfs2(1, n, k, new ArrayList<>());
        return result;
    }

    private void dfs2(int index, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            dfs2(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}

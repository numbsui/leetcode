package com.sld.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 46
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        System.out.println(permute3(nums));
    }

    //方法三：
    private static List<List<Integer>> permute3(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(num, 0, result);
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

    //方法二：
    private static List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> ans = new ArrayList<>();
        if (num.length == 0) return ans;
        List<Integer> l0 = new ArrayList<>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i < num.length; ++i) {
            List<List<Integer>> new_ans = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                for (List<Integer> l : ans) {
                    List<Integer> new_l = new ArrayList<>(l);
                    new_l.add(j, num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }

    //方法一：
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        func(nums, nums.length, 0, result);
        return result;
    }

    private static void func(int[] nums, int len, int cur, List<List<Integer>> list) {
        if (cur == len) {
            list.add(new ArrayList<>(stack));
            return;
        }

        for (int num : nums) {
            if (!stack.contains(num)) {
                stack.push(num);
                func(nums, len, cur + 1, list);
                stack.pop();
            }
        }
    }
}

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
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

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

package com.sld.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 78
 * //相关： 90 46 47
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] num = {1, 2, 3};
        System.out.println(subsets.subsets2(num));
    }

    private List<List<Integer>> subsets2(int[] nums) {
        dfs(new ArrayList<>(), 0, nums);
        return result;
    }

    private void dfs(List<Integer> list, int index, int[] nums) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    private List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1)
                    sub.add(nums[j]);
            }
            result.add(sub);
        }
        return result;
    }
}

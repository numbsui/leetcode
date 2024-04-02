package com.sld.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 90
 * 相关： 78 46 47
 * https://leetcode.cn/problems/subsets-ii/
 */
public class Subsets2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Subsets2 subsets = new Subsets2();
        int[] num = {1, 2, 2};
        System.out.println(subsets.subsetsWithDup(num));
    }

    private List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return result;
    }

    private void dfs(int index, int[] nums) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

}



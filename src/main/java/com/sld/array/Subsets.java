package com.sld.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 78
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(subsets(num));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
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

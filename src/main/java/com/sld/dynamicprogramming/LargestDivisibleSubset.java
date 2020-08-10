package com.sld.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 368
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
    }

    //给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：
    // Si % Sj = 0 或 Sj % Si = 0。如果有多个目标子集，返回其中任何一个均可。
    //
    //输入: [1,2,4,8]
    //输出: [1,2,4,8]
    private static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0;
        int index = -1;
        //1 3 4 8
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + dp[j] > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }

        }
        List<Integer> list = new ArrayList<>();
        while (index != -1) {
            list.add(nums[index]);
            index = pre[index];
        }
        return list;
    }
}

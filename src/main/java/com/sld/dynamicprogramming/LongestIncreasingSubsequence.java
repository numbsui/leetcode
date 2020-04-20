package com.sld.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 300
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS2(nums));
    }

    //方法一：动态规划 O(n*n)
    private static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int result = 1;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //方法二：遍历，将最小序列放入集合，通过二分查找替换 O(nlogn)
    private static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] result = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(result, 0, len, num);
            if (idx < 0) {
                idx = -idx - 1;
            }
            result[idx] = num;
            if (idx == len)
                len = idx + 1;
        }
        return len;
    }
}

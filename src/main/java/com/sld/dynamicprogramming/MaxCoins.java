package com.sld.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 312
 * https://leetcode.com/problems/burst-balloons/
 */
public class MaxCoins {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));

    }

    //167
    private static int maxCoins(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length + 2][length + 2];

        int[] points = new int[length + 2];
        points[0] = points[length + 1] = 1;
        for (int i = 1; i <= length; i++)
            points[i] = nums[i - 1];

        for (int i = length; i >= 0; i--) {
            for (int j = i; j <= length + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][length + 1];
    }
}

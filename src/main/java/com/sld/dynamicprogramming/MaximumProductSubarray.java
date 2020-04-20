package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 152
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {
        if (nums == null) return 0;

        int[][] dp = new int[2][2];

        dp[0][1] = nums[0];
        dp[0][0] = nums[0];
        int result = nums[0];

        int x;
        int y;
        for (int i = 1; i < nums.length; i++) {
            x = i % 2;
            y = (i - 1) % 2;

            //dp方程
            dp[x][0] = Math.max(Math.max(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
            dp[x][1] = Math.min(Math.min(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
            result = Math.max(result, dp[x][0]);
        }
        return result;
    }
}

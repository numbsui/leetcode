package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 53
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray5(nums));
    }

    private static int maxSubArray5(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //方法一：暴力
    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    //方法二：分治
    private static int maxSubArray2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        int l = helper(nums, left, mid);
        int r = helper(nums, mid + 1, right);
        int s = cacl(nums, left, right, mid);
        return Math.max(Math.max(l, r), s);
    }

    private static int cacl(int[] nums, int left, int right, int mid) {
        if (left == right) return nums[left];

        int lmax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i > left - 1; i--) {
            sum += nums[i];
            lmax = Math.max(lmax, sum);
        }

        int rmax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i < right + 1; i++) {
            sum += nums[i];
            rmax = Math.max(rmax, sum);
        }
        return lmax + rmax;
    }

    //方法三：贪心算法
    private static int maxSubArray3(int[] nums) {
        int sum = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            sum = Math.max(sum, cur);
        }
        return sum;
    }

    //方法四：动态规划   -2, 1, -3, 4, -1, 2, 1, -5, 4
    private static int maxSubArray4(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];

            System.out.println("i: " + i);
            System.out.println("nums[i]：" + nums[i]);
            sum = Math.max(nums[i], sum);
        }
        return sum;
    }
}

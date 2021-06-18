package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 416
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        //int[] nums = {2,2,3,5};
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        //1 5 11 5  target 11
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--)
                dp[j] = dp[j] || dp[j - nums[i - 1]];
        }

        return dp[target];
    }
}

package com.sld.backtracking;

/**
 * @author sld
 * <p>
 * leetcode 377
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSumIV {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 32;
        System.out.println(combinationSum4(nums, target));
    }

    /**
     * 遍历 nums，判断如果构成 target 的时候，选择了 nums[i]，那么剩余的 target - nums[i] 仍在 nums 中选的话，会有多少种方法。
     * <p>
     * 对于 nums[0] = 1， 我们要求有多少种方法能够成 target - nums[0] = 4 - 1 = 3，即要求 dp(3)；
     * 对于 nums[1] = 2, 我们要求有多少种方法能够成 target - nums[1] = 4 - 2 = 2，即要求 dp(2)；
     * 对于 nums[2] = 3, 我们要求有多少种方法能够成 target - nums[2] = 4 - 3 = 1，即要求 dp(1)；
     * 所以，dp(4) = dp(3) + dp(2) + dp(1)。然后调用函数继续求解 dp(3), dp(2) 和 dp(1)
     */
    private static int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}

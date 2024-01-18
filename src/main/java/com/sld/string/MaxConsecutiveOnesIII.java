package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 1004
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {

    /**
     * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    //使用滑动窗口
    private static int longestOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                zeros++;
            while (zeros > k) {
                if (nums[left++] == 0)
                    zeros--;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}

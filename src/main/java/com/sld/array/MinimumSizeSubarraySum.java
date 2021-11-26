package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 209
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr],并返回其长度。
     * 如果不存在符合条件的子数组，返回 0 。
     *
     */
    public static void main(String[] args) {

//        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
//        int s = 213;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    //方法一：双指针
    private static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int len = nums.length;

        int result = len + 1;
        int sum = 0;

        while (right < len) {
            while (sum < target && right < len) {
                sum += nums[right++];
            }

            while (sum >= target) {
                result = Math.min(result, right - left);
                sum -= nums[left++];
            }

        }
        return result == len + 1 ? 0 : result;
    }

    //方法二：二分查找
    private static int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int result = len + 1;
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        for (int i = 0; i <= len; i++) {
            int pos = binarySearch(sums, i + 1, len, target + sums[i]);
            if (pos == len + 1) break;
            if (result > pos - i) result = pos - i;
        }
        return result == len + 1 ? 0 : result;
    }

    private static int binarySearch(int[] nums, int left, int right, int key) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= key) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}

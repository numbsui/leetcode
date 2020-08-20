package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 713
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0;
        int result = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product = product * nums[right];
            while (product >= k) {
                product = product / nums[left++];
            }
            result += right - left + 1;
        }
        return result;
    }
}

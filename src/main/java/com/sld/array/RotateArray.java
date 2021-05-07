package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 189
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        //int[] nums = {-1, -100, 3, 99};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     * <p>
     * Example 1:
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * <p>
     * Example 2:
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     *
     * @param nums
     * @param k
     */
    private static void rotate(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;

        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[nums.length - k + i];
        }


        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++)
            nums[i] = tmp[i];
    }
}



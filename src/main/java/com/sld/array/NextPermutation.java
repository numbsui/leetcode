package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 31
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 6, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greaterpermutation of numbers.
     * <p>
     * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
     * <p>
     * The replacement must be in place and use only constant extra memory.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * <p>
     * <p>
     * Example 3:
     * <p>
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     * <p>
     * <p>
     * Example 4:
     * <p>
     * Input: nums = [1]
     * Output: [1]
     *
     * @param nums
     */
    private static void nextPermutation(int[] nums) {

        //4 5 2 6 3 1

        //4 5 3 6 2 1
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

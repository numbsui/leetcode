package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 283
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }

        for (int j = cur; j < nums.length; j++)
            nums[j] = 0;
    }
}

package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 167
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int num1 = numbers[left];
            int num2 = numbers[right];
            if (num1 + num2 == target) {
                return new int[]{left + 1, right + 1};
            } else if (num1 + num2 < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }
}

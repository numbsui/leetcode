package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 167
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {

    /**
     * 给定一个已按照非递减顺序排列的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     *
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标从 1 开始计数 ，所以答案数组应当满足
     * 1 <= answer[0] < answer[1] <= numbers.length 。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     */
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

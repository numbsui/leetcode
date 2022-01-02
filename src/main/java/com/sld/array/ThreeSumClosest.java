package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 16
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。返回这三个数的和。
     * <p>
     * 假定每组输入只存在恰好一个解。
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 1, 55};
        //int[] nums = {0, 0, 0};
        int target = 3;
        System.out.println(threeSumClosest(nums, target));
    }

    //-5 -4 -3 -2 3  result = Integer.MAX_VALUE越界。。
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 100000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum == target) return sum;

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum > target) {
                    while (head < tail && nums[tail] == nums[tail - 1]) tail--;
                    tail--;
                } else {
                    while (head < tail && nums[head] == nums[head + 1]) head++;
                    head++;
                }
            }
        }
        return result;
    }
}
package com.sld.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 1679
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */
public class MaxNumberofKSumPairs {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        System.out.println(maxOperations2(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) > 0) {
                map.put(k - num, map.get(k - num) - 1);
                result++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return result;
    }

    private static int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        //双指针
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                result++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}

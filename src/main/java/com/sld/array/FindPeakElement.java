package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 162
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }

    //峰值元素是指其值大于左右相邻值的元素。给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，
    //找到峰值元素并返回其索引。
    private static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

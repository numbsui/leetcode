package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 153
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 7};
        System.out.println(findMin(nums));
    }

    //456712
    private static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}

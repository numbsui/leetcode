package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 154
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimuminRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end = end - 1;
            }

        }
        return nums[start];
    }
}

package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 81
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchinRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;
        System.out.println(search(nums, target));
    }

    private static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if (nums[low] == nums[mid]) {
                low++;
            } else if (nums[low] < nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

}

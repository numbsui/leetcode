package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 35
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert2(nums, target));
    }

    private static int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return i;
    }

    //二分法
    private static int searchInsert2(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else
                return mid;
        }
        return l;
    }
}

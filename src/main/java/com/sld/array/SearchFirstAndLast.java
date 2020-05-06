package com.sld.array;

import java.util.Arrays;

/**
 * @author suilindong
 * @date 2020/4/20 5:04 下午
 */
public class SearchFirstAndLast {

    public static void main(String[] args) {
        //int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。
    // 找出给定目标值在数组中的开始位置和结束位置。
    //
    //你的算法时间复杂度必须是 O(log n) 级别。
    //
    //如果数组中不存在目标值，返回 [-1, -1]。
    //
    //示例 1:
    //
    //输入: nums = [5,7,7,8,8,10], target = 8
    //输出: [3,4]

    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private static int binarySearch(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int l = binarySearch(nums, target, true);
        if (l == nums.length || nums[l] != target) {
            return result;
        }
        result[0] = l;
        result[1] = binarySearch(nums, target, false) - 1;
        return result;
    }
}


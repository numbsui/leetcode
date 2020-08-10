package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 33
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //int[] nums = {1, 3, 5};
        int target = 1;
        System.out.println(search2(nums, target));
    }

    private static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
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
        return -1;
    }


    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    //你可以假设数组中不存在重复的元素。
    //你的算法时间复杂度必须是 O(log n) 级别。
    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int pivot = findPivot(nums, 0, nums.length - 1);
        System.out.println(pivot);
        if (pivot == -1)
            return binarySearch(nums, 0, nums.length - 1, target);
        if (target == nums[pivot]) return pivot;
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot, target);
        }
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int low, int high, int key) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (key == nums[mid]) return mid;
        if (key < nums[mid]) {
            return binarySearch(nums, low, mid - 1, key);
        }
        return binarySearch(nums, mid + 1, high, key);
    }

    private static int findPivot(int[] nums, int low, int high) {
        if (low > high) return -1;
        if (low == high) return low;
        int mid = (low + high) / 2;
        if (mid < high && nums[mid] > nums[mid + 1])
            return mid;
        if (mid > low && nums[mid] < nums[mid - 1])
            return mid - 1;
        if (nums[low] < nums[mid])
            return findPivot(nums, mid + 1, high);
        return findPivot(nums, low, mid - 1);
    }
}

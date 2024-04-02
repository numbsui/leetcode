package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 80
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesfromSortedArray2 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int[] nums = {1, 2, 3};
        System.out.println(removeDuplicates(nums));
    }


    //最多出现两次
    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[slow - 2]) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }

}

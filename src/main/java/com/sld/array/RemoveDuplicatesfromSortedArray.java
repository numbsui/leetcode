package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 26
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates2(nums));
    }


    private static int removeDuplicates2(int[] nums) {
        int first = 1;

        for (int second = 1; second < nums.length; second++) {
            if (nums[second] != nums[first - 1]) {
                nums[first] = nums[second];
                first++;
            }
        }
        return first;
    }


    private static int removeDuplicates(int[] nums) {
        int repeat = 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                repeat++;
            } else {
                nums[index++] = nums[i];
            }
        }
        return nums.length - repeat;
    }

}

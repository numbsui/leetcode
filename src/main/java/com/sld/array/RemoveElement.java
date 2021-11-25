package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 27
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {
        //int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums = {3, 2, 2, 3};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        int index = 0;

        //双指针
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}

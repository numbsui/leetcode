package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 31
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void main(String[] args) {
        //int[] nums = {4, 5, 2, 6, 3, 1};
        int[] nums = {6, 5, 4, 3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {
        //1.从后往前找到 nums[i] < nums[i+1]的坐标
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //2.从后往前找到最接近nums[i]且比nums[i]大的数，进行交换
        if (i >= 0) {
            int j = nums.length - 1;
            while (i <= j && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        //3.让i后边元素升序排列
        reverse(nums, i + 1);
    }

    static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

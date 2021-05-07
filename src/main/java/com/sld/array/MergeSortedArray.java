package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 88
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 8, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));


    }

    //双指针
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] newArr = new int[m + n];
        int num;
        while (i < m || j < n) {
            if (i == m) {
                num = nums2[j++];
            } else if (j == n) {
                num = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                num = nums1[i++];
            } else {
                num = nums2[j++];
            }
            newArr[i + j - 1] = num;
        }

        System.arraycopy(newArr, 0, nums1, 0, newArr.length);
    }

    //逆向双指针
    //int[] nums1 = {1, 4, 8, 0, 0, 0};
    //        int m = 3;
    //        int[] nums2 = {2, 5, 6};
    //        int n = 3;
    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j = n;
        int num;
        while (i > 0 || j > 0) {
            if (i == -1) {
                num = nums2[j--];
            } else if (j == -1) {
                num = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                num = nums1[i--];
            } else {
                num = nums2[j--];
            }
            nums1[i + j - 1] = num;
        }
    }
}



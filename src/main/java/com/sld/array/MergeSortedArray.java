package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 88
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * <p>
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
     * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     */
    public static void main(String[] args) {
        //int[] nums1 = {1, 4, 8, 0, 0, 0};
        int[] nums1 = {1};
        int m = 1;
        //int[] nums2 = {2, 5, 6};
        int[] nums2 = {};
        int n = 0;
        merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    //方法一： 双指针，新建长度为m+n的数组newArr，遍历num1和num2，将数据填充到newArr中
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

    //方法二： 逆向双指针，逆向遍历num1和num2，将数据直接添加到num1后边
    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int num;
        int index = nums1.length;
        while (index != 0) {
            if (i == -1) {
                num = nums2[j--];
            } else if (j == -1) {
                num = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                num = nums1[i--];
            } else {
                num = nums2[j--];
            }
            nums1[--index] = num;
        }
    }
}



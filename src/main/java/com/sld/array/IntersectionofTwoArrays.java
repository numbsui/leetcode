package com.sld.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sld
 * <p>
 * leetcode 349
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionofTwoArrays {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    /**
     * 数组1排序，遍历数组2，二分查找  6ms
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);

        for (Integer num : nums2) {
            if (binarySearch(nums1, num)) {
                set.add(num);
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            result[index++] = num;
        }
        return result;
    }

    private static boolean binarySearch(int[] nums1, Integer num) {
        int start = 0;
        int end = nums1.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (num == nums1[mid]) {
                return true;
            } else if (num < nums1[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    /**
     * 使用两个set保存数据，第二个set保存交集  4ms
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }

        for (Integer num : nums2) {
            if (set.contains(num)) {
                set2.add(num);
            }
        }

        int[] result = new int[set2.size()];
        int index = 0;
        for (Integer num : set2) {
            result[index++] = num;
        }
        return result;
    }

    /**
     * 排序后使用双指针  2ms
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection3(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            result[index++] = num;
        }
        return result;
    }

}



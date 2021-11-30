package com.sld.array;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 350
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionofTwoArraysII {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    /**
     * 使用两个map保存数据以及次数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num1 : nums1) {
            map1.merge(num1, 1, (a, b) -> a + b);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num2 : nums2) {
            map2.merge(num2, 1, (a, b) -> a + b);
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int loop = 0;
            Integer key = entry.getKey();
            if (map2.get(key) != null) {
                loop = Math.min(map1.get(key), map2.get(key));
            }
            while (loop > 0) {
                list.add(key);
                loop--;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 排序后使用双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] intersection2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }

}



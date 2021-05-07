package com.sld.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 448
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedinanArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers2(nums));
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (map.get(i) == null)
                list.add(i);
        }

        return list;
    }

    private static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }

        return list;
    }
}

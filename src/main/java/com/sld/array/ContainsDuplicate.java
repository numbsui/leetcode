package com.sld.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sld
 * <p>
 * leetcode 217
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 5, -2, -4, 0};
        System.out.println(containsDuplicate(nums));
    }


    private static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1) return true;
        }
        return false;
    }

    private static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}

package com.sld.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author sld
 * <p>
 * leetcode 220
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicateIII {

    public static void main(String[] args) {
        int[] nums = {-1, 2147483647};
        int k = 1;
        int t = 2147483647;
        System.out.println(containsNearbyAlmostDuplicate2(nums, k, t));
    }

    //方法一：平衡树
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceil = set.ceiling(nums[i]);
            if (ceil != null && ceil <= nums[i] + t) return true;

            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= floor + t) return true;

            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }

    //方法二：桶
    private static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long pos = getBucketPosition(nums[i], t + 1);
            if (map.containsKey(pos)) return true;
            if (map.containsKey(pos - 1) && Math.abs(map.get(pos - 1) - nums[i]) <= t) return true;
            if (map.containsKey(pos + 1) && Math.abs(map.get(pos + 1) - nums[i]) <= t) return true;
            map.put(pos, (long) nums[i]);
            if (i >= k) map.remove(getBucketPosition(nums[i - k], t + 1));
        }
        return false;
    }

    private static long getBucketPosition(long num, long gap) {
        return num >= 0 ? num / gap : (num + 1) / gap - 1;
    }
}

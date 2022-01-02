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

    /**
     * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，
     * 同时又满足 abs(i - j) <= k 。
     * <p>
     * 如果存在则返回 true，不存在返回 false。
     */
    public static void main(String[] args) {
        /*int[] nums = {-1, 2147483647};
        int k = 1;
        int t = 2147483647;*/
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    //方法一：平衡树
    //[1,5,9,1,5,9], k = 3, t = 3
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) ts.remove((long) nums[i - k]);
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

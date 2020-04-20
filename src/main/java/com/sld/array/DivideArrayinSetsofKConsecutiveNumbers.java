package com.sld.array;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 1296
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class DivideArrayinSetsofKConsecutiveNumbers {

    public static void main(String[] args) {
        int[] nums = {3,3,2,2,1,1};
        int k = 3;
        System.out.println(isPossibleDivide(nums, k));
    }

    private static boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) return false;

        Queue<Integer> queue = new PriorityQueue<>(len);
        for (int num : nums)
            queue.offer(num);

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 1; i < k; i++) {
                if (!queue.remove(tmp + i))
                    return false;
            }
        }
        return true;
    }

    private static boolean isPossibleDivide2(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) return false;

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int num : nums) {
            int tmp = map.get(num);
            if (tmp == 0) continue;
            map.put(num, tmp - 1);
            for (int i = 1; i < k; i++) {
                int count = map.getOrDefault(num + i, 0);
                if (count == 0) return false;
                map.put(num + i, count - 1);
            }
        }
        return true;
    }
}

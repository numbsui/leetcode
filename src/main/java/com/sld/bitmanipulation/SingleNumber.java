package com.sld.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 136
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber2(nums));
    }

    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                map.remove(num);
            } else {
                map.put(num, 0);
            }
        }
        return map.keySet().iterator().next();
    }

    //相同的两个数异或，结果是0
    private static int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

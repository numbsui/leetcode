package com.sld.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 137
 * https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber2(nums));
    }

    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
                if (map.get(num) == 3) {
                    map.remove(num);
                }
            }
        }
        return map.keySet().iterator().next();
    }

    //位运算，见
    // https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/
    private static int singleNumber2(int[] nums) {
        int a = 0;
        int b = 0;

        for (int num : nums) {
            a = ~b & (a ^ num);
            b = ~a & (b ^ num);
        }
        return a;
    }
}

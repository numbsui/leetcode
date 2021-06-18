package com.sld.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author sld
 * leetcode 264
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class UglyNumberII {

    public static void main(String[] args) {
        int n = 1690;
        System.out.println(nthUglyNumber2(n));
    }

    // 1  2 3 5
    // 2  4 6 10
    // 3  6 9 12
    // 4  8 12 16
    private static int nthUglyNumber(int n) {
        int[] nums = {2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long result = 0L;
        queue.offer(1L);
        set.add(1L);
        for (int i = 0; i < n; i++) {
            result = queue.poll();
            for (int num : nums) {
                long offerNum = result * num;
                if (set.add(offerNum)) {
                    queue.offer(result * num);
                }
            }
        }
        return (int) result;
    }

    private static int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int x = 1, y = 1, z = 1;
        for (int i = 2; i <= n; i++) {
            int num1 = dp[x] * 2;
            int num2 = dp[y] * 3;
            int num3 = dp[z] * 5;
            dp[i] = Math.min((Math.min(num1, num2)), num3);
            if (dp[i] == num1)
                x++;
            if (dp[i] == num2)
                y++;
            if (dp[i] == num3)
                z++;
        }
        return dp[n];
    }

}

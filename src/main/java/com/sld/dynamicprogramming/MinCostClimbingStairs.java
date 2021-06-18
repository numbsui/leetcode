package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 746
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    private static int minCostClimbingStairs(int[] cost) {
        int x = 0;
        int y = 0;
        for (int i = 2; i <= cost.length; i++) {
            int tmp = Math.min(y + cost[i - 1], x + cost[i - 2]);
            x = y;
            y = tmp;
        }
        return y;
    }
}

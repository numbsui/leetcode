package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 279
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于n。
     * 你需要让组成和的完全平方数的个数最少。
     * <p>
     * 给你一个整数 n ，返回和为 n 的完全平方数的最少数量 。
     * <p>
     * 完全平方数是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
     * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     */
    public static void main(String[] args) {
        int n = 8;
        System.out.println(numSquares(n));
    }

    //1 2 3 4 5 6 7 8   8   i-j*j
    //1 2 3 1 2 3 4 2
    private static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}

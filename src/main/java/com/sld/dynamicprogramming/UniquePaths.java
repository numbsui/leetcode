package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 62
 * https://leetcode.cn/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println(uniquePaths(m, n));
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

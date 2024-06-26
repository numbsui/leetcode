package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 63
 * https://leetcode.cn/problems/unique-paths-ii/
 */
public class UniquePaths2 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 1}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        int fill = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                fill = 0;
            dp[i][0] = fill;
        }

        fill = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                fill = 0;
            dp[0][i] = fill;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

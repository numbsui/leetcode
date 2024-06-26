package com.sld.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 44
 * https://leetcode.cn/problems/wildcard-matching/
 */
public class WildcardMatching {

    public static void main(String[] args) {
        String s = "bca";
        String p = "*a";
        System.out.println(isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}

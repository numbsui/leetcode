package com.sld.dynamicprogramming;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 97
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";
        System.out.println(isInterleave(s1, s2, s3));
    }

    //给定三个字符串s1, s2, s3, 验证s3是否是由s1和s2 交错组成的。
    //
    //示例 1:
    //
    //输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    //输出: true
    //示例2:
    //
    //输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    //输出: false
    private static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                else if (j == 0) dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                else dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                            || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[s1.length()][s2.length()];
    }

}

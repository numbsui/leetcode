package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 91
 * 相关：639
 * https://leetcode.cn/problems/decode-ways/
 */
public class DecodeWays {

    public static void main(String[] args) {
        String s = "1208";
        System.out.println(numDecodings(s));
    }

    private static int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }
}

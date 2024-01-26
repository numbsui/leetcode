package com.sld.string;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 5
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "abc435cba";
        System.out.println(longestPalindrome2(s));
    }

    //abcdbc  cbdcba
    //为什么中心是2n-1而不是n 比如有字符串abcba，这时回文子串是abcba，中心是c；又有字符串adccda，这时回文子串是adccda，中心是cc。
    // 由此可见中心点既有可能是一个字符，也有可能是两个字符，当中心为一个字符的时候有n个中心，当中心为两个字符的时候有n-1个中心，所以一共有2n-1个中心。
    // 然后for循环开始从左到右遍历，为什么会有两次expandAroundCenter，一次是i和i本身，一次是i和i+1，这就是上面说到的一个中心与两个中心。
    // 而后会去判断这两种情况下谁的回文子串最长，并标记出这个子串在原字符串中的定位，即start和end。
    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //        String s = "babad";    dabab
    // 0 0 0 0 1
    // 0 1 0 1 0
    // 1 0 2 0 0
    // 0 2 0 3 0
    // 1 0 3 0 0
    private static String longestPalindrome2(String s) {
        int max = 0;
        int end = 0;
        if (s == null || s.length() < 1) return "";
        int length = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                if (dp[i][j] > max) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + dp[i][j] - 1 == i) { //判断下标是否对应
                        max = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        return s.substring(end - max + 1, end + 1);
    }
}
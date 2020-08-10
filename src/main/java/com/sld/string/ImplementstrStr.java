package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 28
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        String haystack = "abdababd", needle = "ababd";
        System.out.println(strStr2(haystack, needle));
    }

    //方法一： substring比较
    private static int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    //方法二： KMP算法
    private static int strStr2(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;

        int m = needle.length();
        int[][] dp = new int[m][256];
        int x = 0;
        dp[0][needle.charAt(0)] = 1;

        for (int i = 1; i < m; i++) {
            //假设下个字符不匹配，此时要回去看影子状态，从而得知跳转到哪个状态
            System.arraycopy(dp[x], 0, dp[i], 0, 256);
            // 只有pat上i的字符匹配，跳转到下个状态
            dp[i][needle.charAt(i)] = i + 1;
            // 更新影子状态
            x = dp[x][needle.charAt(i)];
        }

        int s = 0;
        for (int i = 0; i < haystack.length(); i++) {
            s = dp[s][haystack.charAt(i)];
            if (s == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
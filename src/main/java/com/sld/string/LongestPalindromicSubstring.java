package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 5
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    //为什么中心是2n-1而不是n 比如有字符串abcba，这时回文子串是abcda，中心是c；又有字符串adccda，这时回文子串是adccda，中心是cc。
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
}

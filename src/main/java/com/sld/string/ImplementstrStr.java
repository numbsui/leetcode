package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 28
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 14
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix2(strs));

    }

    //方法一：扫描数组，看是否匹配定义的前缀
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //方法二：分治法
    private static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        return divideStrs(strs, 0, strs.length - 1);
    }

    private static String divideStrs(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            String left = divideStrs(strs, l, (l + r) / 2);
            String right = divideStrs(strs, (l + r) / 2 + 1, r);
            return calCommonPrefix(left, right);
        }
    }

    private static String calCommonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}

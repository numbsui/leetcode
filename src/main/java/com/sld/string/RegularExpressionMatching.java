package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 10
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }

    //给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
    //
    //'.' 匹配任意单个字符
    //'*' 匹配零个或多个前面的那一个元素
    //所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。

    //如果模式串中有星号，它会出现在第二个位置，这种情况下，我们可以直接忽略模式串中这一部分，
    // 或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符,如果两种操作中有任何一种
    // 使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
    private static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        //aaaaa  a*
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}

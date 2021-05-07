package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 434
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 */
public class NumberSegmentsInString {

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        System.out.println(countSegments(s));
    }

    private static int countSegments(String s) {
        int result = 0;
        s = " " + s;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')
                result++;
        }
        return result;
    }

}

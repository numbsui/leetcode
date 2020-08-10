package com.sld.string;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 521
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/
 */
public class LongestUncommonSubsequenceII {

    public static void main(String[] args) {
        String[] strs = {
                "aabbcc", "aabbcc", "cb", "abc", "mmnnqq"
        };
        System.out.println(findLUSlength(strs));
    }

    private static int findLUSlength(String[] strs) {

        Arrays.sort(strs, (o1, o2) -> o2.length() - o1.length());

        System.out.println(Arrays.toString(strs));
        for (int i = 0; i < strs.length; i++) {
            boolean match = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isMatch(strs[i], strs[j])) {
                    match = true;
                    break;
                }
            }
            if (!match) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private static boolean isMatch(String s1, String s2) {
        int i, j;
        for (i = 0, j = 0; i < s2.length() && j < s1.length(); i++) {
            if (s1.charAt(j) == s2.charAt(i)) j++;
        }
        return j == s1.length();
    }
}

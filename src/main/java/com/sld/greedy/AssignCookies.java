package com.sld.greedy;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 860
 * https://leetcode.com/problems/lemonade-change/
 */
public class AssignCookies {

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }

    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookieLength = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < cookieLength; i++, j++) {
            while (j < cookieLength && g[i] > s[j]) {
                j++;
            }
            if (j < cookieLength)
                count++;
        }
        return count;
    }
}

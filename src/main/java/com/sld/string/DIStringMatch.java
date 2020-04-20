package com.sld.string;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 942
 * https://leetcode.com/problems/di-string-match/
 */
public class DIStringMatch {

    public static void main(String[] args) {
        String s = "IDID";
        System.out.println(Arrays.toString(diStringMatch(s)));
    }

    private static int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }
}

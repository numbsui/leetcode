package com.sld.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sld
 * <p>
 * 判断是否是回文串，可以用动态规划：
 * <p>
 * 我们可以将字符串 ss 的每个子串 s[i..j] 是否为回文串预处理出来，使用动态规划即可。设 f(i, j)表示 s[i..j]是否为回文串，那么有状态转移方程：
 * <p>
 * f(i,j)={
 * True,                       i≥j
 * f(i+1,j−1)∧(s[i]=s[j]),    otherwise
 * ​       }
 * ​
 * 其中 ∧ 表示逻辑与运算，即 s[i..j]s[i..j] 为回文串，当且仅当其为空串（i>j），其长度为 1（i=j），或者首尾字符相同且 s[i+1..j-1]为回文串。
 * 预处理完成之后，我们只需要 O(1) 的时间就可以判断任意 s[i..j]是否为回文串了。
 * <p>
 * <p>
 * leetcode 131
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    private List<List<String>> result = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private int length;
    private boolean[][] f;

    public static void main(String[] args) {
        String s = "aabba";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> lists = palindromePartitioning.partition(s);
        System.out.println(lists);
    }

    public List<List<String>> partition(String s) {
        length = s.length();
        f = new boolean[length][length];
        for (int i = 0; i < length; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = length - 1; i >= 0; --i) {
            for (int j = i + 1; j < length; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(0, s);
        return result;
    }

    private void dfs(int i, String s) {
        if (i == length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (f[i][j]) {
                list.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}

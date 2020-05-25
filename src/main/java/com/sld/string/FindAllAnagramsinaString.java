package com.sld.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 438
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsinaString {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        //String s = "baa";
        //String p = "aa";
        System.out.println(findAnagrams(s, p));
    }

    //给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
    //字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
    //
    //说明：
    //字母异位词指字母相同，但排列不同的字符串。
    //不考虑答案输出的顺序。
    private static List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.equals("") || p == null || p.equals("") || s.length() < p.length())
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int count = 0;
        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        for (int i = 0; i < p.length(); i++)
            arr1[p.charAt(i)]++;

        //s  cbaebabacd   p  abc
        while (right != s.length()) {
            char c = s.charAt(right++);
            if (arr1[c] > 0) {
                arr2[c]++;
                if (arr1[c] == arr2[c])
                    count++;
            }

            while (count == p.length()) {
                if (right - left == p.length()) {
                    result.add(left);
                }
                c = s.charAt(left++);
                if (arr1[c] > 0) {
                    arr2[c]--;
                    if (arr2[c] < arr1[c])
                        count--;
                }
            }
        }

        return result;
    }

    //s cbaebabacd   p abc
    private static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) count--;
            if (count == 0) list.add(left);
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
}

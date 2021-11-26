package com.sld.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 76
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    //方法一：双指针，判断字符串是否包含，使用数组保存
    private static String minWindow(String s, String t) {
        if (s == null || s.equals("") || t == null || t.equals("") || s.length() < t.length())
            return "";
        String result = "";
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;

        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        for (int i = 0; i < t.length(); i++)
            arr1[t.charAt(i)]++;

        //ADOBECODEBANC   ABC
        while (right != s.length()) {
            char c = s.charAt(right++);
            arr2[c]++;
            if (arr1[c] > 0 && arr1[c] >= arr2[c])
                count++;

            while (count == t.length()) {
                c = s.charAt(left);
                if (arr1[c] > 0 && arr1[c] >= arr2[c])
                    count--;
                if (right - left < min) {
                    min = right - left;
                    result = s.substring(left, right);
                }
                arr2[c]--;
                left++;
            }
        }
        return result;
    }

    //方法二：双指针，判断字符串是否包含，使用map保存
    private static String minWindow2(String s, String t) {
        int left = 0;
        int right = 0;
        String result = "";
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int count = tMap.size();

        while (right != s.length()) {
            char c = s.charAt(right++);
            if (!tMap.containsKey(c))
                continue;
            tMap.put(c, tMap.get(c) - 1);
            if (tMap.get(c) == 0)
                count--;

            while (count == 0) {
                while (left < right && !tMap.containsKey(s.charAt(left)))
                    left++;
                //更新记录
                if (right - left < min) {
                    min = right - left;
                    result = s.substring(left, right);
                }
                char c1 = s.charAt(left);
                tMap.put(c1, tMap.get(c1) + 1);
                if (tMap.get(c1) > 0) count++;
                left++;
            }
        }
        return result;
    }
}

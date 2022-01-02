package com.sld.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 242
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaramn";
        System.out.println(isAnagram2(s, t));
    }

    //将两个字符串排序，比较是否相同
    private static boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ts);
        return Arrays.equals(cs, ts);
    }

    //使用hashMap保存每个字符出现的次数，比较两个字符串。
    private static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Character character : map.keySet()) {
            if (map.get(character) != 0)
                return false;
        }
        return true;
    }
}

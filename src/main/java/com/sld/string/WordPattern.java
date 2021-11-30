package com.sld.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 290
 * https://leetcode.com/problems/word-pattern/
 */
class WordPattern {

    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     */
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }


    private static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strings = s.split(" ");
        if (strings.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (!map.containsValue(strings[i])) {
                    map.put(pattern.charAt(i), strings[i]);
                } else
                    return false;
            } else {
                String value = map.get(pattern.charAt(i));
                if (!value.equals(strings[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
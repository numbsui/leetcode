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
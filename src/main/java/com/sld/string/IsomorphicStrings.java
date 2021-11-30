package com.sld.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 205
 * https://leetcode.com/problems/word-pattern/
 */
class IsomorphicStrings {

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * <p>
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * <p>
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     */
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(isIsomorphic2(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map1.containsKey(sc) && map1.get(sc) != tc ||
                    map2.containsKey(tc) && map2.get(tc) != sc) {
                return false;
            } else {
                map1.put(sc, tc);
                map2.put(tc, sc);
            }
        }
        return true;
    }

    private static boolean isIsomorphic2(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
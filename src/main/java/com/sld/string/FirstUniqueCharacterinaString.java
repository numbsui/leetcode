package com.sld.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 387
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
class FirstUniqueCharacterinaString {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar2(s));
    }

    private static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], -1);
            } else {
                map.put(chars[i], i);
            }
        }

        int length = s.length();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value != -1 && value < length) {
                length = value;
            }
        }
        if (length == s.length())
            return -1;
        else
            return length;
    }

    private static int firstUniqChar2(String s) {
        if (s.length() == 0) return -1;

        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        int index = 0;
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] == 1) return index;
            index++;
        }
        return -1;
    }
}
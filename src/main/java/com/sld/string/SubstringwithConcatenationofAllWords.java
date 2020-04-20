package com.sld.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 30
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringwithConcatenationofAllWords {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) return result;
        int len = words[0].length();

        Map<String, Integer> map1 = new HashMap<>();
        for (String word : words) {
            int value = map1.getOrDefault(word, 0);
            map1.put(word, value + 1);
        }

        for (int i = 0; i < s.length() - wordNum * len + 1; i++) {
            Map<String, Integer> map2 = new HashMap<>();
            int num = 0;
            while (num < wordNum) {
                String word = s.substring(i + num * len, i + (num + 1) * len);
                if (map1.containsKey(word)) {
                    int value = map2.getOrDefault(word, 0);
                    map2.put(word, value + 1);
                    if (map2.get(word) > map1.get(word))
                        break;
                } else
                    break;
                num++;
            }
            if (num == wordNum)
                result.add(i);
        }

        return result;
    }
}

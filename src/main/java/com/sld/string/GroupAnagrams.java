package com.sld.string;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 49
 * https://leetcode.com/problems/group-anagrams/
 */
class GroupAnagrams {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(strs));
    }

    //方法一：将字符串排序最为key，anagram列表作为value
    // [["bat"],["nat","tan"],["ate","eat","tea"]]
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String newStr = new String(array);
            List<String> list = map.getOrDefault(newStr, new ArrayList<>());
            list.add(str);
            map.put(newStr, list);
        }
        return new ArrayList<>(map.values());
    }

    //方法二：由于互为字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的，
    //        故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
    private static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = new char[26];
            for (int i = 0; i < str.length(); i++) {
                array[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (array[i] > 0) {
                    sb.append('a' + i);
                    sb.append(array[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
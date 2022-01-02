package com.sld.string;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 451
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
class SortCharactersByFrequency {

    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     */
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort3(s));
    }

    private static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++)
                sb.append(entry.getKey());
        }
        return sb.toString();
    }

    private static String frequencySort2(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++)
                sb.append(entry.getKey());
        }
        return sb.toString();
    }

    private static String frequencySort3(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        // 构造 HashMap。Key：s 中的每个元素；Value：对应元素出现的次数（即频率）
        Map<Character, Integer> store = new HashMap<>();

        for (char c : s.toCharArray()) {
            // 填充 HashMap。如果当前 Key c 不存在，getOrDefault() 方法返回默认值 0；
            // 否则返回当前 Key c 对应的 Value。
            // 不管哪种情况最后都在 0 或者 Value 的基础上 +1。
            store.put(c, store.getOrDefault(c, 0) + 1);
        }

        // 构造一个桶的集合（即一系列桶），桶的个数为 s 的长度 +1，因为 buckets[0] 没有意义
        // 目的是将出现频率为 i 的字符放到第 i 个桶里（即 buckets[i]）
        List<Character>[] buckets = new List[s.length() + 1];

        for (char key : store.keySet()) {
            // 某个字符在 HashMap 中的 Value 是几就会被放到第几个桶里
            int value = store.get(key);

            if (buckets[value] == null) {
                // 如果某个桶还未放入过字符（即未初始化），则初始化其为一个数组
                buckets[value] = new ArrayList<>();
            }

            buckets[value].add(key); // 然后将字符放到桶中
        }

        StringBuilder res = new StringBuilder();

        //时间复杂度：O(n + k)，其中 n 是字符串 s 的长度，k 是字符串 s 包含的不同字符的个数。
        //遍历字符串统计每个字符出现的频率需要 O(n) 的时间。
        //创建桶并将不同字符加入桶需要 O(k) 的时间。
        //生成排序后的字符串，需要 O(k) 的时间遍历桶，以及 O(n) 的时拼接字符串间。
        //因此总时间复杂度是 O(n + k)。
        for (int i = buckets.length - 1; i > 0; --i) {
            // 遍历每个桶
            if (buckets[i] != null) {
                // 如果桶里有字符
                for (char j : buckets[i]) {
                    // 遍历桶里的每个字符
                    for (int k = i; k > 0; --k) {
                        // 字符出现了几次就向 res 中添加几次该字符
                        res.append(j);
                    }
                }
            }
        }
        return res.toString();
    }

}
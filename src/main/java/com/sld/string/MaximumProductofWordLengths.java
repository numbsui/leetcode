package com.sld.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * leetcode 318
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */
public class MaximumProductofWordLengths {

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct2(words));
    }


    private static int maxProduct(String[] words) {

        int n = words.length;
        int[] masks = new int[n];

        int bitmask;
        for (int i = 0; i < n; ++i) {
            bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                bitmask |= 1 << ch - 'a';
            }
            masks[i] = bitmask;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }

    private static int maxProduct2(String[] words) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        int bitmask;
        for (String word : words) {
            bitmask = 0;
            for (char ch : word.toCharArray()) {
                bitmask |= 1 << ch - 'a';
            }
            hashmap.put(bitmask, Math.max(hashmap.getOrDefault(bitmask, 0), word.length()));
        }

        int result = 0;
        for (int i : hashmap.keySet())
            for (int j : hashmap.keySet())
                if ((i & j) == 0) result = Math.max(result, hashmap.get(i) * hashmap.get(j));

        return result;
    }

}

package com.sld.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sld
 * <p>
 * leetcode 820
 * https://leetcode.com/problems/short-encoding-of-words/
 */
public class ShortEncodingofWords {

    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }

    private static int minimumLengthEncoding(String[] words) {
        int result = 0;
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Set<String> removeSet = new HashSet<>();
        for (String str : set) {
            for (int i = 1; i < str.length(); i++) {
                if (set.contains(str.substring(i)))
                    removeSet.add(str.substring(i));
            }
        }
        set.removeAll(removeSet);
        for (String s : set)
            result += s.length() + 1;
        return result;
    }
}

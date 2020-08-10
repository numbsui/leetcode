package com.sld.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 151
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInaString {

    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
    }


    private static String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}

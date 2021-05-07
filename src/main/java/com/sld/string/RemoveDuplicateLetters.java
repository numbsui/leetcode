package com.sld.string;

import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 316
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {

        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }


    /**
     * Given a string s, remove duplicate letters so that every letter appears once and only once.
     * You must make sure your result is the smallest in lexicographical order among all possible results.
     *
     * Example 1:
     * Input: s = "bcabc"
     * Output: "abc"
     *
     *
     * Example 2:
     * Input: s = "cbacdcbc"
     * Output: "acdb"
     *
     * @param s
     * @return
     */
    private static String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();

        int[] arr = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        //cbacdcbc
        for (char c : s.toCharArray()) {
            arr[c - 'a']--;
            if (visited[c - 'a'])
                continue;

            while (!stack.isEmpty() && stack.peek() > c && arr[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack)
            result.append(c);

        return result.toString();
    }
}

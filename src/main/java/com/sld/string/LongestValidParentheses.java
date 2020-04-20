package com.sld.string;

import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 32
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    private static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
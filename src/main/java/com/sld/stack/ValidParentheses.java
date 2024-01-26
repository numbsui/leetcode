package com.sld.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sld
 * <p>
 * leetcode 20
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */
    public static void main(String[] args) {

        String s = "[(){}]";
        System.out.println(isValid(s));
    }

    //()[]{}
    private static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                if (!stack.empty() && stack.peek() == map.get(s.charAt(i))) {
                    stack.pop();
                } else
                    return false;
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}

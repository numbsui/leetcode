package com.sld.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 22
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen("", result, n, n);
        return result;
    }

    private static void gen(String subString, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(subString);
            return;
        }

        if (left > 0) {
            gen(subString + "(", result, left - 1, right);
        }

        if (right > left) {
            gen(subString + ")", result, left, right - 1);
        }
    }
}

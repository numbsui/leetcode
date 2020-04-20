package com.sld.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 17
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    private static List<String> output = new ArrayList<>();

    private static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backTrace("", digits);
        return output;
    }

    private static void backTrace(String combination, String digits) {
        if (digits.length() == 0)
            output.add(combination);
        else {
            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backTrace(combination + letter, digits.substring(1));
            }
        }
    }
}

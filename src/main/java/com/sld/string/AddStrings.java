package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 415
 * https://leetcode.com/problems/add-strings/
 */
class AddStrings {

    public static void main(String[] args) {
        String num1 = "555";
        String num2 = "555";
        System.out.println(addStrings(num1, num2));
    }

    //189 26
    private static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int number1 = 0;
        int number2 = 0;
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            number1 = i < 0 ? 0 : num1.charAt(i) - '0';
            number2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (number1 + number2 + carry) % 10;
            carry = (number1 + number2 + carry) / 10;
            sb.append(sum);
        }

        if (carry != 0) {
            sb.append((number1 + number2 + carry) / 10);
        }
        return sb.reverse().toString();
    }
}
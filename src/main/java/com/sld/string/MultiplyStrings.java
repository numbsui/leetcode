package com.sld.string;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 43
 * https://leetcode.com/problems/multiply-strings/
 */
class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply2(num1, num2));
    }

    private static String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int[] array = new int[length1 + length2];

        for (int i = length1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = length2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                array[i + j + 1] += n1 * n2;
            }
        }

        for (int i = length1 + length2 - 1; i > 0; i--) {
            int carry = array[i] / 10;
            array[i - 1] += carry;
            array[i] = array[i] % 10;
        }

        StringBuilder sb = new StringBuilder();
        if (array[0] != 0) {
            sb.append(array[0]);
        }
        for (int i = 1; i < array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }

    /**
     * 计算形式
     * num1
     * x num2
     * ------   738  0516
     * result
     */
    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0 
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    private static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }
}
package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 8
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringtoInteger {

    public static void main(String[] args) {
        String str = "4193 with words";
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi(str));

    }

    private static int myAtoi(String str) {
        if (str.length() == 0) return 0;
        char[] charArray = str.toCharArray();
        int flag = 1;
        int i, pop;
        int result = 0;
        for (i = 0; i < str.length(); i++) {
            if (charArray[i] == '+') {
                i++;
                break;
            }
            if (charArray[i] == '-') {
                i++;
                flag = -1;
                break;
            }
            if (charArray[i] == ' ') continue;
            if (charArray[i] < '0' || charArray[i] > '9') {
                return 0;
            } else
                break;
        }

        if (i == str.length()) return 0;

        for (; i < str.length(); i++) {
            if (charArray[i] < '0' || charArray[i] > '9') return result;
            pop = (charArray[i] - 48) * flag;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return Integer.MAX_VALUE;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
                return Integer.MIN_VALUE;
            result = result * 10 + pop;
        }
        return result;
    }
}

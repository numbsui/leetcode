package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 38
 * https://leetcode.com/problems/count-and-say/
 */
public class CountandSay {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
    }

    private static String countAndSay(int n) {
        String num = "1";
        for (int i = 0; i < n - 1; i++) {
            num = calcu(num.toCharArray());
        }
        return num;
    }

    private static String calcu(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char ch = chars[0];
        int temp = 1, i = 1;
        while (i < chars.length) {
            if (chars[i] == ch) {
                temp++;
            } else {
                sb.append(temp).append(chars[i - 1]);
                ch = chars[i];
                temp = 1;
            }
            i++;
        }
        sb.append(temp).append(chars[i - 1]);
        return sb.toString();
    }
}

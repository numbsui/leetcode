package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 58
 * https://leetcode.cn/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    private static int lengthOfLastWord(String s) {
        int length = s.length();
        int count = 0;
        while (length > 0) {
            if (s.charAt(length - 1) == ' ') {
                length--;
            } else
                break;
        }

        if (length == 0) return 0;
        while (length > 0) {
            if (s.charAt(length - 1) == ' ')
                break;
            count++;
            length--;
        }

        return count;
    }
}

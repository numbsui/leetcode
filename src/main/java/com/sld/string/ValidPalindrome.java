package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 125
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     */
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}

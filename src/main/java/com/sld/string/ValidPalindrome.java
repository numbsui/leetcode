package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 125
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }


    /**
     * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * <p>
     * Example 1:
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     *
     * @param s
     * @return
     */
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

package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 345
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
class ReverseVowelsofaString {

    private static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        //String s = "leetcode";
        String s = "aA";
        System.out.println(reverseVowels(s));
    }

    private static boolean isVoewl(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' || c == 'A' ||
                c == 'O' || c == 'E' || c == 'I' || c == 'U';
    }

    private static String reverseVowels(String s) {

        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (!isVoewl(charArray[start])) {
                start++;
                continue;
            }

            if (!isVoewl(charArray[end])) {
                end--;
                continue;
            }
            char tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
            start++;
            end--;
        }
        return String.valueOf(charArray);
    }

}
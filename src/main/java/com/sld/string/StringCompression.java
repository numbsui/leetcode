package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 443
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompression {

    public static void main(String[] args) {

        char[] c = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(c));
    }


    /**
     * Given an array of characters chars, compress it using the following algorithm:
     * <p>
     * Begin with an empty string s. For each group of consecutive repeating characters in chars:
     * <p>
     * If the group's length is 1, append the character to s.
     * Otherwise, append the character followed by the group's length.
     * The compressed string s should not be returned separately,
     * but instead be stored in the input character array chars.
     * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
     * <p>
     * After you are done modifying the input array, return the new length of the array.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: chars = ["a","a","b","b","c","c","c"]
     * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: chars = ["a"]
     * Output: Return 1, and the first character of the input array should be: ["a"]
     * Explanation: The only group is "a", which remains uncompressed since it's a single character.
     * <p>
     * <p>
     * Example 3:
     * <p>
     * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
     * <p>
     * <p>
     * Example 4:
     * <p>
     * Input: chars = ["a","a","a","b","b","a","a"]
     * Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
     * Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2".
     * Note that each group is independent even if two groups have the same character.
     *
     * @param chars
     * @return
     */
    private static int compress(char[] chars) {
        char c = chars[0];
        int len = 1;
        int index = 1;
        for (int i = 1; i < chars.length; i++) {
            if (c == chars[i]) {
                len++;
            } else {
                if (len != 1) {
                    for (char lenChar : String.valueOf(len).toCharArray()) {
                        chars[index++] = lenChar;
                    }
                }

                c = chars[i];
                chars[index++] = c;
                len = 1;
            }
        }

        if (len != 1) {
            for (char lenChar : String.valueOf(len).toCharArray()) {
                chars[index++] = lenChar;
            }
        }

        //System.out.println(String.valueOf(chars));

        return index;
    }
}

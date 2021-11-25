package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 389
 * https://leetcode.com/problems/find-the-difference/
 */
class FindtheDifference {

    public static void main(String[] args) {
        String s = "ae";
        String t = "aea";
        System.out.println(findTheDifference(s, t));
    }


    //方法一： 计算s中每个字符出现的次数，遍历t，出现的字符减1，减为负数的则为答案
    private static char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }

    //方法二： 计算两个字符串中字符的和，差值即为答案
    private static char findTheDifference2(String s, String t) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length(); ++i) {
            count1 += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            count2 += t.charAt(i);
        }
        return (char) (count2 - count1);
    }

    //方法三：两个字符串中字符异或
    private static char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

}
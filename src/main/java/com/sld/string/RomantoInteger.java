package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 13
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomantoInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    //把一个小值放在大值的左边，就是做减法，否则为加法。在代码实现上，可以往后看多一位，对比当前位与后一位的大小关系，
    // 从而确定当前位是加还是减法。当没有下一位时，做加法即可。
    //也可保留当前位的值，当遍历到下一位的时，对比保留值与遍历位的大小关系，再确定保留值为加还是减。最后一位做加法即可。
    private static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

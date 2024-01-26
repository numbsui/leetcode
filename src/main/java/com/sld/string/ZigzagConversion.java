package com.sld.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 6
 * https://leetcode.cn/problems/zigzag-conversion
 */
class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    //PAYPALISHIRING
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    //PAHNAPLSIIGYIR
    private static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int flag = -1;
        int i = 0;
        for (Character c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || numRows - i == 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }
        return result.toString();
    }
}
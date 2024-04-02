package com.sld.dynamicprogramming;

/**
 * @author sld
 * <p>
 * leetcode 639
 * 相关：91
 * https://leetcode.cn/problems/decode-ways-ii/
 */
public class DecodeWays2 {

    public static void main(String[] args) {
        String s = "7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*";
        System.out.println(numDecodings(s));
    }

    private static int numDecodings(String s) {
        int mod = 1000000007;
        int length = s.length();

        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= length; ++i) {
            c = b * check1(s.charAt(i - 1)) % mod;
            if (i > 1) {
                c = (c + a * check2(s.charAt(i - 2), s.charAt(i - 1))) % mod;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    private static int check1(char c) {
        if (c == '0') {
            return 0;
        }
        return c == '*' ? 9 : 1;
    }

    private static int check2(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        }

        if (c1 == '*') {
            return c2 <= '6' ? 2 : 1;
        }
        if (c2 == '*') {
            if (c1 == '1') {
                return 9;
            }
            if (c1 == '2') {
                return 6;
            }
            return 0;
        }
        return (c1 != '0' && (c1 - '0') * 10 + (c2 - '0') <= 26) ? 1 : 0;
    }
}

package com.sld.math;

/**
 * @author sld
 * leetcode 258
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }
    //38  11 2
//38  3*10 + 8  = 3*9 + 3 + 8 = 3*9 + 1*9 + 2
    private static int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num % 10 > 0 || num / 10 > 0) {
                int x = num % 10;
                num = num / 10;
                sum += x;
            }
            num = sum;
        }
        return num;
    }
}

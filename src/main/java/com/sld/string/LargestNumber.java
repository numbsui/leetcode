package com.sld.string;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 179
 * https://leetcode.com/problems/largest-number/
 */
class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9, 1, 99};
        //int[] nums = {0, 0};
        System.out.println(largestNumber2(nums));
    }


    //方法一：字符串比较
    private static String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strings[i] = nums[i] + "";
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, (a, b) -> {
            String x = a + b;
            String y = b + a;
            return y.compareTo(x);
        });
        System.out.println(Arrays.toString(strings));

        if (strings[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String string : strings) sb.append(string);
        return sb.toString();
    }

    //方法二：整数比较，比字符串比较快很多
    private static String largestNumber2(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        //9 5  34   3  30
        Arrays.sort(numsArr, (a, b) -> {
            long x = 10, y = 10;
            while (x <= a) {
                x *= 10;
            }
            while (y <= b) {
                y *= 10;
            }
            //如34 和 3 比较，则 a=34 b=3
            //a和b拼接得到343或334， 所以判断x是否小于a，
            // 小于的话扩大10倍，则x*b+a = 100*3 + 34 = 334
            return (int) (x * b + a - y * a - b);
        });
        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}
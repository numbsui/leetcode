package com.sld.bitmanipulation;

/**
 * @author sld
 *
 * leetcode 231
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerofTwo {

    public static void main(String[] args) {
        int n = 218;
        System.out.println(isPowerOfTwo(n));
    }

    //所有的2的n次方的数，二进制中都只有一个1
    private static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}

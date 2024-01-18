package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 * <p>
 * leetcode 1109
 * https://leetcode.com/problems/corporate-flight-bookings/
 */
public class CorporateFlightBookings {

    public static void main(String[] args) {
        int[][] bookings = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        int n = 5;
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }

    private static int[] corpFlightBookings2(int[][] bookings, int n) {

        int[] result = new int[n];
        for (int[] booking : bookings) {
            int index1 = booking[0];
            int index2 = booking[1];
            int num = booking[2];
            for (int i = index1 - 1; i < index2; i++) {
                result[i] += num;
            }
        }
        return result;
    }

    /**
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * <p>
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti
     * （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * <p>
     * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
     */
    private static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        int l, r, seat;
        for (int[] booking : bookings) {
            l = booking[0] - 1;
            r = booking[1] - 1;
            seat = booking[2];

            res[l] += seat;
            if (r < n - 1) res[r + 1] -= seat;
        }

        for (int i = 1; i < n; i++)
            res[i] += res[i - 1];

        return res;
    }
}

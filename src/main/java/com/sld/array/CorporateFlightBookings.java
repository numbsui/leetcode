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

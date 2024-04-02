package com.sld.math;

import java.util.Arrays;

/**
 * @author sld
 * leetcode 59
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class SpiralMatrix2 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }

    private static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int top = 0;
        int total = n * n;
        int index = 1;
        while (left <= right && top <= bottom && index <= total) {
            for (int i = left; i <= right; i++) {
                result[top][i] = index++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                result[i][right] = index++;
            }

            for (int i = right - 1; i >= left; i--) {
                result[bottom][i] = index++;
            }

            for (int i = bottom - 1; i > top; i--) {
                result[i][left] = index++;
            }
            left++;
            top++;
            bottom--;
            right--;
        }
        return result;
    }
}

package com.sld.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * leetcode 54
 * https://leetcode.cn/problems/spiral-matrix/
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int bottom = m - 1;
        int top = 0;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    result.add(matrix[bottom][i]);
                }

                for (int i = bottom; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            bottom--;
            top++;
        }

        return result;
    }
}

package com.sld.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author sld
 * <p>
 * leetcode 85
 * https://leetcode.cn/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle2(matrix));
    }

    private static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] arrs = new int[row][col];

        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        arrs[i][j] = 1;
                    } else {
                        arrs[i][j] = arrs[i][j - 1] + 1;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(arrs));
        //1, 0, 1, 0, 0
        //1, 0, 1, 2, 3
        //1, 2, 3, 4, 5
        //1, 0, 0, 1, 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = arrs[i][j];
                int s = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, arrs[k][j]);
                    s = Math.max(s, width * (i - k + 1));
                }
                result = Math.max(result, s);
            }
        }

        return result;
    }

    //优化，使用单调栈
    private static int maximalRectangle2(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] arrs = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        arrs[i][j] = 1;
                    } else {
                        arrs[i][j] = arrs[i][j - 1] + 1;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(arrs));
        //1, 0, 1, 0, 0
        //1, 0, 1, 2, 3
        //1, 2, 3, 4, 5
        //1, 0, 0, 1, 0
        int result = 0;
        for (int j = 0; j < col; j++) {
            int[] up = new int[row];
            int[] down = new int[row];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < row; i++) {
                while (!stack.isEmpty() && arrs[stack.peek()][j] >= arrs[i][j]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    up[i] = -1;
                } else {
                    up[i] = stack.peek();
                }
                stack.push(i);
            }

            stack.clear();
            for (int i = row - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arrs[stack.peek()][j] >= arrs[i][j]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    down[i] = row;
                } else {
                    down[i] = stack.peek();
                }
                stack.push(i);
            }

            System.out.println("up: " + Arrays.toString(up));
            System.out.println("down: " + Arrays.toString(down));

            for (int i = 0; i < row; i++) {
                result = Math.max(result, (down[i] - up[i] - 1) * arrs[i][j]);
            }
        }
        return result;
    }
}



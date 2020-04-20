package com.sld.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sld
 * <p>
 * leetcode 977
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresofaSortedArray {

    public static void main(String[] args) {
        int[] A = {-4, -3, -1};
        System.out.println(Arrays.toString(sortedSquares2(A)));
    }

    //方法一：排序
    private static int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++)
            result[i] = A[i] * A[i];

        Arrays.sort(result);
        return result;
    }

    //方法二：双指针
    private static int[] sortedSquares2(int[] A) {
        int[] result = new int[A.length];
        int i = 0;
        int j = 0;
        int len = A.length;
        while (j < len && A[j] < 0) {
            j++;
        }
        i = j - 1;
        int k = 0;

        while (i >= 0 && j < len) {
            if (A[i] * A[i] < A[j] * A[j]) {
                result[k++] = A[i] * A[i];
                i--;
            } else {
                result[k++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            result[k++] = A[i] * A[i];
            i--;
        }

        while (j < len) {
            result[k++] = A[j] * A[j];
            j++;
        }

        return result;
    }
}

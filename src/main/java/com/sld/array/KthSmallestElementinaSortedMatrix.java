package com.sld.array;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 378
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElementinaSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {4, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest3(matrix, k));
    }

    private static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < n; j++) {
                list.add(aMatrix[j]);
            }
        }

        list.sort(Integer::compareTo);
        return list.get(k - 1);
    }

    /**
     * 使用堆
     *
     * @param matrix
     * @param k
     * @return
     */
    private static int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        //将第一列保存在堆中，同时保存坐标
        for (int i = 0; i < n; i++) {
            int[] num = new int[]{matrix[i][0], i, 0};
            priorityQueue.offer(num);
        }

        //遍历k次，更新堆
        for (int i = 0; i < k - 1; i++) {
            int[] poll = priorityQueue.poll();
            if (poll[2] != n - 1) {
                int[] num = new int[]{matrix[poll[1]][poll[2] + 1], poll[1], poll[2] + 1};
                priorityQueue.offer(num);
            }
        }
        return Objects.requireNonNull(priorityQueue.poll())[0];
    }


    /**
     * 二分查找法，最快
     * @param matrix
     * @param k
     * @return
     */
    private static int kthSmallest3(int[][] matrix, int k) {
        int length = matrix.length;
        int left = matrix[0][0];
        int right = matrix[length - 1][length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            //如果大于mid的数大于k，则说明要找的数在mid左边，则从左边继续寻找
            if (func(matrix, mid, k, length)) {
                right = mid;
            } else {
                //如果大于mid的数小于k，则说明要找的数在mid右边，则从右边继续寻找
                left = mid + 1;
            }
        }
        return left;
    }

    //1, 5, 9
    // 4, 11, 13
    // 12, 13, 15
    private static boolean func(int[][] matrix, int mid, int k, int length) {
        int i = length - 1;
        int j = 0;
        int sum = 0;
        //计算小于mid的数的总个数，如mid=8,则计算第一列小于8的有两个1和4，计算第二列小于8的有一个5
        //则小于8的数有3个
        while (i >= 0 & j < length) {
            if (matrix[i][j] <= mid) {
                sum += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return sum >= k;
    }

}


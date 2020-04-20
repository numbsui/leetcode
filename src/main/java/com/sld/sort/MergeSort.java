package com.sld.sort;

import java.util.Arrays;

/**
 * @author sld
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] num = {21, 32, 7, 14, 25, 3, 1};
        mergeSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    //1.选择相邻两个数组成一个有序序列。
    //2.选择相邻的两个有序序列组成一个有序序列。
    //3.重复第二步，直到全部组成一个有序序列。
    private static void mergeSort(int[] num, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(num, left, mid);
        mergeSort(num, mid + 1, right);
        merge(num, left, mid, right);
    }

    private static void merge(int[] num, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (num[i] < num[j]) {
                tmp[index++] = num[i++];
            } else
                tmp[index++] = num[j++];
        }

        while (i <= mid) {
            tmp[index++] = num[i++];
        }

        while (j <= right) {
            tmp[index++] = num[j++];
        }

        for (int k = 0; k < tmp.length; k++) {
            num[left + k] = tmp[k];
        }
    }
}

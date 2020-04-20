package com.sld.sort;

import java.util.Arrays;

/**
 * @author sld
 * 冒泡排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] num = {21, 32, 7, 14, 25, 3, 1};
        heapSort(num);
        System.out.println(Arrays.toString(num));
    }

    private static void heapSort(int[] num) {
        //构建大顶堆
        for (int i = num.length / 2 - 1; i >= 0; i--)
            adjustHeap(num, i, num.length);

        //每次将堆顶与最后一个元素交换，调整大顶堆
        for (int i = num.length - 1; i > 0; i--) {
            swap(num, 0, i);
            adjustHeap(num, 0, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjustHeap(int[] num, int i, int length) {
        int temp = num[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k < length - 1 && num[k] < num[k + 1]) {
                k++;
            }

            //如果子节点大于父节点，将子节点值赋给父节点
            if (num[k] > temp) {
                num[i] = num[k];
                i = k;
            } else
                break;
        }
        num[i] = temp;
    }
}

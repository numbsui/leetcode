package com.sld.sort;

import java.util.Arrays;

/**
 * @author sld
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] num = {21, 32, 7, 14, 25, 3, 1};
        System.out.println(Arrays.toString(bubbleSort(num)));
    }

    //1.设置循环次数。
    //2.设置开始比较的位数，和结束的位数。
    //3.两两比较，将最小的放到前面去。
    //4.重复2、3步，直到循环次数完毕。
    private static int[] bubbleSort(int[] num) {
        int len = num.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (num[j - 1] > num[j]) {
                    int temp = num[j - 1];
                    num[j - 1] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }
}

package com.sld.sort;

import java.util.Arrays;

/**
 * @author sld
 * 简单选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] num = {21, 32, 7, 14, 25, 3, 1};
        System.out.println(Arrays.toString(selectSort(num)));
    }

    //1.首先确定循环次数，并且记住当前数字和当前位置。
    //2.将当前位置后面所有的数与当前数字进行对比，小数赋值给key，并记住小数的位置。
    //3.比对完成后，将最小的值与第一个数的值交换。
    //4.重复2、3步。
    private static int[] selectSort(int[] num) {
        int len = num.length;
        for (int i = 0; i < len; i++) {
            int min = num[i];
            int cur = i;
            for (int j = i + 1; j < len; j++) {
                if (num[j] < min) {
                    min = num[j];
                    cur = j;
                }
            }
            num[cur] = num[i];
            num[i] = min;
        }
        return num;
    }
}

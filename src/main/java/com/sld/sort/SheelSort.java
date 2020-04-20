package com.sld.sort;

import java.util.Arrays;

/**
 * @author sld
 * 希尔排序
 */
public class SheelSort {

    public static void main(String[] args) {
        int[] num = {21, 32, 7, 14, 25, 3, 1};
        System.out.println(Arrays.toString(sheelSort(num)));
    }

    //1.首先确定分的组数。
    //2.然后对组中元素进行插入排序。
    //3.然后将length/2，重复1,2步，直到length=0为止。
    private static int[] sheelSort(int[] num) {
        int len = num.length;
        while (len != 0) {
            len /= 2;
            for (int i = 0; i < len; i++) {
                for (int j = i + len; j < num.length; j += len) {
                    int insertNum = num[j];
                    int k = j - len;
                    while (k >= 0 && num[k] > insertNum) {
                        num[k + len] = num[k];
                        k -= len;
                    }
                    num[k + len] = insertNum;
                }
            }
        }
        return num;
    }
}

package com.sld.sort;

import java.util.Arrays;

/**
 * @author sld
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] num = {21, 32, 7, 14, 25, 3, 1};
        System.out.println(Arrays.toString(insertSort(num)));
    }

    //1.首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入.
    //2.设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
    //3.从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
    //4.将当前数放置到空着的位置，即j+1。
    private static int[] insertSort(int[] num) {
        int len = num.length;
        for (int i = 1; i < len; i++) {
            int insertNum = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] > insertNum) {
                num[j + 1] = num[j];
                j--;
            }
            num[j + 1] = insertNum;
        }
        return num;
    }
}

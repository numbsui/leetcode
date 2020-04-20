package com.sld.array;

import java.util.Arrays;

/**
 * @author sld
 */
public class RemoveNum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 4, 5};
        System.out.println(Arrays.toString(uniqueArray(arr)));
        System.out.println(removeDuplicates(arr));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    private static int[] uniqueArray(int[] array) {
        if (array.length == 0) return null;
        if (array.length == 1) return array;

        int pointer = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[pointer]) {
                pointer++;
                array[pointer] = array[i];
            }
        }

        //copy the data to another array

        int[] uniArray = new int[pointer + 1];
        for (int i = 0; i <= pointer; i++) {
            uniArray[i] = array[i];
        }
        return uniArray;

    }
}

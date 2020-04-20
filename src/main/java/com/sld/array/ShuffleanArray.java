package com.sld.array;

import java.util.Arrays;
import java.util.Random;

/**
 * @author sld
 * <p>
 * leetcode 35
 * https://leetcode.com/problems/search-insert-position/
 */
public class ShuffleanArray {

    private int[] array;
    private int[] original;
    private Random random = new Random();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ShuffleanArray shuffleanArray = new ShuffleanArray(nums);
        System.out.println(Arrays.toString(shuffleanArray.shuffle()));
        System.out.println(Arrays.toString(shuffleanArray.reset()));
    }

    public ShuffleanArray(int[] nums) {
        this.array = nums;
        original = array.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            int b = random.nextInt(array.length - i) + i;
            int temp = array[i];
            array[i] = array[b];
            array[b] = temp;
        }
        return array;
    }
}

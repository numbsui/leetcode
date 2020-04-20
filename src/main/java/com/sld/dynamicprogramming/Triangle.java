package com.sld.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 120
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        System.out.println(minimumTotal(triangle));
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;

        int[] result = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j + 1]);
            }
        }
        return result[0];
    }
}

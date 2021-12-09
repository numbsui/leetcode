package com.sld.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 447
 * https://leetcode.com/problems/number-of-boomerangs/
 */
public class NumberofBoomerangs {

    /**
     * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
     * 回旋镖 是由点(i, j, k)表示的元组,其中i和j之间的距离和i和k之间的欧式距离相等（需要考虑元组的顺序）。
     * <p>
     * 返回平面上所有回旋镖的数量。
     */
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }


    //题目所描述的回旋镖可以视作一个V型的折线。我们可以枚举每个points[i]，将其当作V型的拐点。设points中有m个点到points[i]的距离均相等，
    // 我们需要从这m点中选出2个点当作回旋镖的2个端点，由于题目要求考虑元组的顺序，因此方案数即为在m个元素中选出2个不同元素的排列数，
    //据此，我们可以遍历points，计算并统计所有点到points[i]的距离，将每个距离的出现次数记录在哈希表中，然后遍历哈希表，并用上述公式计算
    // 并累加回旋镖的个数。在代码实现时，我们可以直接保存距离的平方，避免复杂的开方运算。
    private static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int[] arr1 : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] arr2 : points) {
                int distance = (arr1[0] - arr2[0]) * (arr1[0] - arr2[0]) + (arr1[1] - arr2[1]) * (arr1[1] - arr2[1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                result += value * (value - 1);
            }
        }
        return result;
    }
}

package com.sld.divideAndConquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sld
 * <p>
 * leetcode 169
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        //int[] nums = {3, 2, 3};
        //int[] nums = {1};
        System.out.println(majorityElement3(nums));
    }

    //方法一：使用map保存数组，key为数组的值，value为每个值出现的次数，判断value > n/2，则找到
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    //方法二：将数组排序，数组中间即为结果
    private static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //方法三：Boyer-Moore 投票算法
    /*本质上， Boyer-Moore 算法就是找 nums 的一个后缀 suf ，其中 suf[0] 就是后缀中的众数。我们维护一个计数器，
    如果遇到一个我们目前的候选众数，就将计数器加一，否则减一。只要计数器等于 0 ，我们就将 nums 中之前访问的数字全部忘记 ，
    并把下一个数字当做候选的众数。直观上这个算法不是特别明显为何是对的，我们先看下面这个例子（竖线用来划分每次计数器归零的情况）

            [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]

    首先，下标为 0 的 7 被当做众数的第一个候选。在下标为 5 处，计数器会变回0 。所以下标为 6 的 5 是下一个众数的候选者。
    由于这个例子中 7 是真正的众数，所以通过忽略掉前面的数字，我们忽略掉了同样多数目的众数和非众数。因此，7 仍然是剩下数字中的众数。*/
    private static int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count ++;
            } else {
                count --;
            }
        }
        return candidate == null ? 0 : candidate;
    }
}

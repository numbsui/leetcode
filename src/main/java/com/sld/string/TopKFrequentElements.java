package com.sld.string;

import java.util.*;

/**
 * @author sld
 * <p>
 * leetcode 347
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        //int[] nums = {1, 2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent4(nums, k)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    private static int[] topKFrequent2(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        queue.addAll(map.entrySet());
        int[] result = new int[k];
        int index = 0;
        while (!queue.isEmpty() && index < k) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            result[index] = entry.getKey();
            index++;
        }
        return result;
    }


    private static int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0 && result.size() < k; --i) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }


    private static int[] topKFrequent4(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}
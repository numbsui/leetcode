package com.sld.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * <p>
 * leetcode 89
 * https://leetcode.cn/problems/gray-code/
 */
public class GrayCode {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(grayCode(n));
    }

    //格雷编码公式 (i/2)^i，具体参考百度
    private static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add((i >> 1) ^ i);
        }
        return result;
    }
}

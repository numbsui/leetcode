package com.sld.array;

/**
 * @author sld
 * <p>
 * 国内最大的web站点统计服务商CNZZ监测某客户站点正在进行首页广告位更新，该首页有n个广告位，有3种广告(A,B,C) ，A广告占用1个广告位，
 * B广告占用2个广告位; C广告占用3个;广告连在一起，可任意组合，为了保证首页的美观，A广告的左右相邻不能出现A广告，B和C则无限制。
 * 问该站点首页有多少种广告位布局方案。输入: n个广告位输出: z种布局方案
 */

import java.util.Scanner;

public class AdvertiseCount {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        core(n);
        System.out.println(count);
    }

    public static void core(int n) {
        if (n < 3) {
            count = count == 0 ? 0 : 1;
            return;
        }
        dfs(n, 0, 0);
    }

    public static void dfs(int n, int k, int flag) {
        if (k == n) {
            count++;
            return;
        }
        if (k > n) {
            return;
        }
        if (flag != 1) {
            dfs(n, k + 1, 1);
        }
        dfs(n, k + 2, 2);
        dfs(n, k + 3, 3);
    }
}


package com.sld.od;

import java.util.*;

/**
 * @author sld  3
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int n = scan.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(scan.nextInt());
            }
            for (int num : set)
                System.out.println(num);
        }
    }
}

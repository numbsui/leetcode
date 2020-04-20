package com.sld.od;

import java.util.Scanner;

/**
 * @author sld  4
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String str = scan.next();
            String s = "00000000";
            if (str.length() <= 0) {
                System.out.println(0);
            } else if (str.length() <= 8) {
                System.out.println(str + s.substring(0, 8 - str.length()));
            } else {
                int n = str.length() % 8;
                for (int i = 0; i < str.length() - n; i += 8) {
                    System.out.println(str.substring(i, i + 8));
                }
                if (n != 0)
                    System.out.println(str.substring(str.length() - n) + s.substring(0, 8 - n));
            }
        }
    }
}

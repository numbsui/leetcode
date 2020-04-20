package com.sld.od;

import java.util.Scanner;

/**
 * @author sld  6
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int num = scan.nextInt();
            while (num != 1) {
                for (int i = 2; i <= num; i++) {
                    if (num % i == 0) {
                        num /= i;
                        System.out.print(i + " ");
                        break;
                    }
                }
            }
        }
    }
}

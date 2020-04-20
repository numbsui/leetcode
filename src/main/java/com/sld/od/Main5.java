package com.sld.od;

import java.util.Scanner;

/**
 * @author sld  6
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            double num = scan.nextDouble();
            int result = (int) num;
            if (num - result >= 0.5)
                System.out.println(result + 1);
            else
                System.out.println(result);
        }
    }
}

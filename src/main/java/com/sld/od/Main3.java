package com.sld.od;

import java.util.Scanner;

/**
 * @author sld  5
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String str = scan.next();
            System.out.println(Integer.parseInt(str.substring(2), 16));
        }
    }
}

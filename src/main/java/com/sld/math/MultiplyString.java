package com.sld.math;

/**
 * @author suilindong
 * @date 2020/4/22 11:06 上午
 */
public class MultiplyString {

    public static void main(String[] args) {
        String s1 = "58";
        String s2 = "677";
        System.out.println(8 * 677);
        System.out.println(5 * 677);
        System.out.println(multiply(s1, s2));
    }

    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        //58  677
        //5416   33850  39266   5 4 1 6    3 9 2 6 6
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
}

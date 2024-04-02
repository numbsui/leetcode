package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 67
 * https://leetcode.cn/problems/add-binary/
 */
class AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "11";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        int length1 = a.length() - 1;
        int length2 = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        while (length1 >= 0 || length2 >= 0) {
            int num1 = length1 >= 0 ? a.charAt(length1) - '0' : 0;
            int num2 = length2 >= 0 ? b.charAt(length2) - '0' : 0;
            sum = num1 + num2 + carry;
            if (sum == 1 || sum == 0) {
                sb.append(sum);
                carry = 0;
            } else if (sum == 2) {
                sb.append(0);
                carry = 1;
            } else {
                sb.append(1);
                carry = 1;
            }
            length1--;
            length2--;
        }


        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
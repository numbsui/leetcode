package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 468
 * https://leetcode.com/problems/validate-ip-address/
 */
public class ValidateIPAddress {

    public static void main(String[] args) {
        String IP = "1.0.1.";
        System.out.println(validIPAddress(IP));
    }

    private static String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) return validIPv4(IP);
        else if (IP.chars().filter(ch -> ch == ':').count() == 7) return validIPv6(IP);
        else return "Neither";
    }

    private static String validIPv4(String ip) {
        String[] strings = ip.split("\\.", -1);
        for (String s : strings) {
            if (s.length() == 0 || s.length() > 3) return "Neither";
            if (s.charAt(0) == '0' && s.length() != 1) return "Neither";
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) return "Neither";
            }
            if (Integer.parseInt(s) > 255) return "Neither";
        }
        return "IPv4";
    }

    private static String validIPv6(String ip) {
        String[] strings = ip.split(":", -1);
        String str = "0123456789abcdefABCDEF";
        for (String s : strings) {
            if (s.length() == 0 || s.length() > 4) return "Neither";
            for (char c : s.toCharArray()) {
                if (str.indexOf(c) == -1) return "Neither";
            }
        }
        return "IPv6";
    }
}

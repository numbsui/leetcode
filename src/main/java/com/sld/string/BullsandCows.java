package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 299
 * https://leetcode.com/problems/bulls-and-cows/
 */
class BullsandCows {

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(getHint(secret, guess));
    }


    private static String getHint(String secret, String guess) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int A = 0;
        int B = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                A++;
            } else {
                arr1[secret.charAt(i) - '0']++;
                arr2[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            B += Math.min(arr1[i], arr2[i]);
        }
        return A + "A" + B + "B";
    }
}
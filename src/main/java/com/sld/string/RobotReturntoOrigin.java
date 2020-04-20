package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 657
 * https://leetcode.com/problems/robot-return-to-origin/
 */
public class RobotReturntoOrigin {

    public static void main(String[] args) {
        String moves = "UDUDUDUDUDUDUDUDL";
        System.out.println(judgeCircle(moves));
    }

    private static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                x++;
            } else if (c == 'D') {
                x--;
            } else if (c == 'L') {
                y++;
            } else {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}

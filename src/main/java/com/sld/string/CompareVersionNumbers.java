package com.sld.string;

/**
 * @author sld
 * <p>
 * leetcode 165
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {

        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(compareVersion(version1, version2));
    }


    /**
     * Given two version numbers, version1 and version2, compare them.
     * <p>
     * Version numbers consist of one or more revisions joined by a dot '.'.
     * Each revision consists of digits and may contain leading zeros.
     * Every revision contains at least one character.
     * Revisions are 0-indexed from left to right, with the leftmost revision being revision 0,
     * the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
     * <p>
     * To compare version numbers, compare their revisions in left-to-right order.
     * Revisions are compared using their integer value ignoring any leading zeros.
     * This means that revisions 1 and 001 are considered equal.
     * If a version number does not specify a revision at an index, then treat the revision as 0.
     * For example, version 1.0 is less than version 1.1 because their revision 0s are the same,
     * but their revision 1s are 0 and 1 respectively, and 0 < 1.
     *
     * @param version1
     * @param version2
     * @return
     */
    private static int compareVersion(String version1, String version2) {

        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        int max = Math.max(s1.length, s2.length);
        for (int i = 0; i < max; i++) {
            int i1;
            int i2;
            if (i >= s1.length) {
                i1 = 0;
            } else {
                i1 = Integer.parseInt(s1[i]);
            }

            if (i >= s2.length) {
                i2 = 0;
            } else {
                i2 = Integer.parseInt(s2[i]);
            }

            int result = Integer.compare(i1, i2);
            if (result != 0)
                return result;
        }
        return 0;
    }
}

package com.sld.array;

/**
 * @author sld
 * <p>
 * leetcode 4
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    private static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] nums = new int[length1 + length2];
        if (length1 == 0) {
            nums = nums2;
        }
        if (length2 == 0) {
            nums = nums1;
        }

        int i = 0, j = 0, k = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i];
                i++;
            } else {
                nums[k++] = nums2[j];
                j++;
            }
            if (i == length1) {
                while (j < length2) {
                    nums[k++] = nums2[j++];
                }
                break;
            }
            if (j == length2) {
                while (i < length1) {
                    nums[k++] = nums1[i++];
                }
                break;
            }
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int mid = nums.length / 2;
        if (nums.length % 2 != 0) {
            return nums[mid];
        } else {
            return (nums[mid - 1] + nums[mid]) / 2.0;
        }
    }
}


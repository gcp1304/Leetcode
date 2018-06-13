package com.chandra.problems;

/**
 * 283. Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * */

public class Problem_283 {
    public static class Solution1 {

        // copy the non-zero values whenever zero is disovered keeping index to non-zero value
        // append zeros by overwriting the non-zero values after processing all of them
        // But appending zeros causes number of operations to grow
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i=0;i<nums.length;i++) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }

            while (j < nums.length) {
                nums[j++] = 0;
            }
        }
    }

    // More optimized solution is to swap the non-zero values with zero values keeping an index of non-zero value
    // Since we perform only non-zero values swap that's the minimal operations required.
    public static class Solution2 {
        public void moveZeroes(int[] nums) {
            int j=0;
            for (int i=0;i<nums.length;i++) {
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
        }
    }

}

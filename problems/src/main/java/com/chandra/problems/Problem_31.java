package com.chandra.problems;

import java.util.Arrays;

/**
 * 31. Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place and use only constant extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Problem_31 {
    public static class Solution_1 {
        public static void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) return;

            int maxElementIndex = nums.length-1;

            // find the element which is less than right element from right side
            for (int i=nums.length-2;i>=0;i--) {
                if(nums[i] < nums[i+1]) {
                    // now find the element which is greater than the swap position element detected to swap
                    for (int j=nums.length-1;j>i;j--) {
                        if (nums[j] > nums[i]){
                            maxElementIndex = j;
                            break;
                        }
                    }
                    swap(nums, i, maxElementIndex);
                    // sort the remaining right side elements to form a next high number
                    Arrays.sort(nums, i+1, nums.length);
                    return;
                }
            }

            // if there's not next high number i.e if input is in decreasing order, then we sort in increasing and return it
            Arrays.sort(nums);
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution_1.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

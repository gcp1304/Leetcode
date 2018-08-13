package com.chandra.problems;

/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 Example 1:

 Input: [3,4,5,1,2]
 Output: 1
 Example 2:

 Input: [4,5,6,7,0,1,2]
 Output: 0
 */
public class Problem_153 {
    public static class Solution_1 {
        // Brute Force - O(n)
        public int findMin(int[] nums) {
            if (nums.length == 1) return nums[0];
            if (nums[0] < nums[nums.length-1]) return nums[0];

            for (int i=0;i<nums.length-1;i++) {
                if (nums[i] > nums[i+1]) return nums[i+1];
            }

            return -1;
        }
    }

    public static class Solution_2 {

        // Binary Search
        public int findMin(int[] nums) {
            if (nums.length == 1) return nums[0];
            if (nums[0] < nums[nums.length-1]) return nums[0];

            int left = 0, right = nums.length-1;
            while (left <= right) {
                if (right - left == 1) return nums[right];

                int mid = left + (right - left)/2;
                if (nums[mid] > nums[right]) left = mid;
                else right = mid;
            }

            return nums[left];
        }
    }
}

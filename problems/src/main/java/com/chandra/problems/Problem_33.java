package com.chandra.problems;

/**
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 */
public class Problem_33 {
    // Binary Search
    public static class Solution_1 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length-1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] < nums[right]) {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] nums1 = new int[]{4,5,6,7,0,1,2};
        int target1 = 0;

        int[] nums2 = new int[]{4,5,6,7,0,1,2};
        int target2 = 3;

        System.out.println(solution_1.search(nums1, target1)); // 4
        System.out.println(solution_1.search(nums2, target2)); // -1
    }
}

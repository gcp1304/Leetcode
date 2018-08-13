package com.chandra.problems;


/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]

 */
public class Problem_34 {

    // Regular binary search
    // whenever target is found walk to left and right checking for same target since the input array is sorted
    public static class Solution_1 {
        public int[] searchRange(int[] nums, int target) {
            int start = 0, end = nums.length-1;

            while (start <= end) {
                int mid = (end - start) / 2;

                if (nums[mid] == target) {
                    int left=mid, right = mid;

                    while (left>=0 && target == nums[left])
                        left--;

                    while (right <= nums.length-1 && target == nums[right]) right ++;

                    return new int[]{left+1, right-1};
                } else if (target < nums[mid])
                    end = mid-1;
                else start = mid+1;
            }

            return new int[]{-1, -1};
        }
    }
}

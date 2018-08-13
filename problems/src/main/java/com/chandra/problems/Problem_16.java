package com.chandra.problems;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class Problem_16 {
    public static class Solution_1 {

        /* Time Complexity:
            Sort - O(nlogn)
            while loop inside for loop provies O(n*n)

            Total = O(nlogn) + O(n*n) ~ O(n*n)
         */

        public static int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length == 0) return Integer.MIN_VALUE; // Clarify what to return

            // Important - Sort
            Arrays.sort(nums);
            int closestSum = Integer.MAX_VALUE;
            int minDistance = Integer.MAX_VALUE; // To keep track of how far the current sum is from target in order to determine closet sum to target
            for (int i=0;i<nums.length-2;i++) { // we loop through last by 2 elements
                // keeping 1 number constant we go through the rest of elements in 2 pointers style to find 2 more elements for 3 sum
                int start = i+1;
                int end = nums.length-1;

                while (start < end) { // loop until both pointer meet
                    int twoSum = nums[start] + nums[end];
                    int possibleTarget = twoSum + nums[i];
                    if (possibleTarget == target) return possibleTarget; // if we have found target, return

                    int distanceToTarget = Math.abs(target - possibleTarget); // distance to target tells how far the current sum is from target
                    // since we want closest sum, the distance between current sum and target should be as small as possible
                    // hence we keep track of minimum distance discovered so far, whenever we have distance smaller than minimum distance
                    // we store the distance and the sum as well
                    if (distanceToTarget < minDistance) {
                        minDistance = distanceToTarget;
                        closestSum = possibleTarget;
                    }

                    // increment or decrement pointers based on the current sum less than or more than target
                    if (possibleTarget < target) start++;
                    else end--;
                }
            }

            // finally return the closest sum.
            // we reach here only if there are not numbers resulting in given target sum
            return closestSum;
        }

    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(Solution_1.threeSumClosest(nums, target)); // o/p = 2
    }
}

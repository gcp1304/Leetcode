package com.chandra.problems;

/**
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Problem_53 {
    public static class Solution {

        // Kadane's algorithm
        public int maxSubArray(int[] nums) {
            int maxSum = 0, curSum = 0;
            for (int num : nums) {
                curSum += num;
                if (curSum < 0) curSum = 0;

                maxSum = Math.max(maxSum, curSum);
            }

            return maxSum;
        }
    }


    public static class Solution_1 {
        //Modified version of Kadane's algo

        /**
         *
         * Kadane's algorithm fails when all the input array elements are negative.
         *
         * Below solution takes care of all negative input array elements and returns the appropriate sum
         * In this case, we can modify the algorithm, to keep a flag hasAllNegative initialized to true.
         If a positive or 0 element is seen in the array, then set hasAllNegative = false.
         Also, while traversing the array, keep track of maximum negative element.
         Finally, if hasAllNegative is true, then return maxNegativeSum, else return maxSum.
         */
        public int maxSubArray(int[] nums) {
            int maxSum = 0, curSum = 0;
            boolean allNegative = true;
            int maxNegative = Integer.MIN_VALUE;
            for (int num : nums) {
                if (allNegative && num >= 0) allNegative = false;
                else if (allNegative && num < 0 && maxNegative < num) maxNegative = num;

                curSum += num;
                if (curSum < 0) curSum = 0;

                maxSum = Math.max(curSum, maxSum);
            }

            return allNegative == true ? maxNegative : maxSum;
        }
    }
}

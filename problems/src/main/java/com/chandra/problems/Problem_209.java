package com.chandra.problems;

/**
 * 209. Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 Example:

 Input: s = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 Follow up:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class Problem_209 {
    public static class Solution1 {
        //O(N) - keep a moving window expand until sum>=s, then shrink util sum<s. Each time after shrinking, update length.
        public static int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
            while (end < nums.length) {
                sum += nums[end++];
                while (sum >= s) {
                    min = Math.min(min, 1 + (end - start));
                    sum -= nums[start++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }

        public static void main(String[] args) {
            int[] nums = {2,3,1,2,4,3};
            int s = 7;
            System.out.println(minSubArrayLen(s, nums));
        }
    }
}

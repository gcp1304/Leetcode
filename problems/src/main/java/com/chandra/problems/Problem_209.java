package com.chandra.problems;

public class Problem_209 {
    public static class Solution1 {
        //O(N) - keep a moving window expand until sum>=s, then shrink util sum<s. Each time after shrinking, update length.
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
            while (end < nums.length) {
                sum += nums[end++];
                while (sum >= s) {
                    min = Math.min(min, end - start);
                    sum -= nums[start++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}

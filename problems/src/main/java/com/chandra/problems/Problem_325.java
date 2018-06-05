package com.chandra.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. Maximum Size Subarray Sum Equals k
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * <p>
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * <p>
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * <p>
 * Follow Up:
 * Can you do it in O(n) time?
 */
public class Problem_325 {
    /*
    Tips:
    The subarray sum reminds me the range sum problem. Preprocess the input array such that you get the range sum in constant time.
    sum[i] means the sum from 0 to i inclusively
    the sum from i to j is sum[j] - sum[i - 1] except that from 0 to j is sum[j].
    j-i is equal to the length of subarray of original array. we want to find the max(j - i) for any sum[j]
    we need to find if there is a previous sum[i] such that sum[j] - sum[i] = k Instead of scanning from 0 to j -1 to
    find such i, we use hashmap to do the job in constant time.
    However, there might be duplicate value of of sum[i] we should avoid overriding its index as we want the max j - i,
    so we want to keep i as left as possible.
     */
    public static class Solution_1 {
        public int maxSubArrayLen(int[] nums, int k) {
            if(nums == null || nums.length == 0) return 0;

            int n = nums.length;

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int max = 0;
            int sum = 0;
            for (int i=0;i<n;i++) {
                sum += nums[i];
                // store every index sum
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }

                if (map.containsKey(sum - k)) {
                    max = Math.max(max, i - map.get(sum - k));
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] input1 = new int[] {1, -1, 5, -2, 3};
        int k1 = 3;

        int[] input2 = new int[]{-2,-1,2,1};
        int k2 = 1;

        System.out.println(solution_1.maxSubArrayLen(input1, k1));
        System.out.println(solution_1.maxSubArrayLen(input2, k2));
    }
}

package com.chandra.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 Example 1:
 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 Example 2:
 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 Note: The length of the given binary array will not exceed 50,000.
 */
public class Problem_525 {
    public static class Solution_1 {
        public int findMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1); // initialize the map, which means at index zero, the length of contiguous subarray is -1
            // for E.g [0, 1], o/p = 2 if we don't inialize index zero with -1 length, then o/p is zero.
            int max = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] == 0 ? -1 : 1;
                if (map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Problem_525.Solution_1 solution_1 = new Solution_1();
        int[] nums = new int[]{0,1,0,0,1};
        System.out.println(solution_1.findMaxLength(nums));
    }
}

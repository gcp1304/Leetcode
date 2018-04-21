package com.chandra.problems;

import java.util.HashSet;

/**
 * 128. Longest Consecutive Sequence
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class Problem_128 {
    public static class Solution1 {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return 1;

            HashSet<Integer> set = new HashSet<>();
            int maxLen = 1;

            for (int num : nums) {
                set.add(num);
            }

            for (int num : nums) {

                int left = num - 1;
                int right = num + 1;
                int curLen = 1;

                // keep checking all consecutive numbers on left side
                while (set.contains(left)) {
                    curLen++;
                    set.remove(left); // this is because we do not want to repeat checking from other side
                    left--;
                }

                // keep checking all the consecutive numbers on right side
                while (set.contains(right)) {
                    curLen++;
                    set.remove(right);
                    right++;
                }

                maxLen = Math.max(maxLen, curLen);
            }

            return maxLen;
        }
    }

    public static class Solution2 {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return 1;

            HashSet<Integer> set = new HashSet<>();
            int maxLen = 1;

            for (int num : nums) {
                set.add(num);
            }

            for (int num : nums) {
                if (set.remove(num)) {
                    int len = 1;

                    // check all the consecutive numbers towards left
                    int val = num;
                    while (set.remove(val - 1)) val--;
                    len += num - val;

                    // check all the consecutive numbers towards left
                    val = num;
                    while (set.remove(val + 1)) val++;
                    len += val - num;

                    maxLen = Math.max(maxLen, len);
                }
            }
            return maxLen;
        }
    }


    // Thanks to Stefan solution at https://leetcode.com/problems/longest-consecutive-sequence/discuss/41057/Simple-O(n)-with-Explanation-Just-walk-each-streak
    public static class Solution3 { //
        public int longestConsecutive(int[] nums) {
            // If you closely observe in frist two solution we only need to check for 1 direction.
            // Since if we start with first element there's no left elements and if there are any consecutive numbers
            // we would have already encountered.

            // the whole idea here is to find the least number and check all the consecutive numbers from there
            // to find the longest consecutive sequence.

            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return 1;

            HashSet<Integer> set = new HashSet<>();
            int maxLen = 1;

            for (int num : nums) {
                set.add(num);
            }

            for (int num : nums) {
                if (!set.contains(num-1)) { // since we are moving from left to right, we don't need to check left
                    // hence this if condition
                    int m = num+1;
                    while (set.remove(m)) m++;

                    maxLen = Math.max(maxLen, m - num);
                }
            }
            return maxLen;
        }
    }
}

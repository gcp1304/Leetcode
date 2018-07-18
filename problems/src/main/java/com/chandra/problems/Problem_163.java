package com.chandra.problems;

import java.util.ArrayList;
import java.util.List;


/**
 * 163.Missing Ranges
 *
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return [“2”, “4->49”, “51->74”, “76->99”].
 */
public class Problem_163 {
    public static class Solution {
        //O(n) time O(1) space solution
        public static List<String> missingRanges(int[] nums, int lower, int upper) {
            List<String> res = new ArrayList<>();

            for (int num : nums) {
                if (num >= lower) {
                    if (num == lower) {
                        lower++;
                    } else {
                        res.add(findMissing(lower, num - 1));
                        lower = num + 1;
                    }
                }
            }

            if (lower <= upper) {
                res.add(findMissing(lower, upper));
            }

            return res;
        }

        public static String findMissing(int low, int high) {
            return low == high ? String.valueOf(low) : String.format("%d->%d", low, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        List<String> res = Problem_163.Solution.missingRanges(nums, 0, 99);
        System.out.println(res.toString());
    }
}

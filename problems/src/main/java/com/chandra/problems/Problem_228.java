package com.chandra.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 228. Summary Ranges
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 Example 1:

 Input:  [0,1,2,4,5,7]
 Output: ["0->2","4->5","7"]
 Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 Example 2:

 Input:  [0,2,3,4,6,8,9]
 Output: ["0","2->4","6","8->9"]
 Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class Problem_228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        StringBuilder sb = new StringBuilder();
        int start = nums[0];
        for (int i=1;i<nums.length;i++) {
            if (nums[i] != nums[i-1] + 1) {
                result.add(start + "" + (start == nums[i-1] ? "" : "->" + nums[i-1]));
                start = nums[i];
            }
        }

        result.add(start + "" + (start == nums[nums.length-1] ? "" : "->"  + nums[nums.length-1]));

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(Arrays.deepToString(Problem_228.summaryRanges(nums).toArray()));
    }
}

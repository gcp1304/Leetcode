package com.chandra.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: [1,2,2]
 Output:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */

public class Problem_90 {
    public static class Solution_1 {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums); // sort is important to identify duplicate elements
            backtracking(res, nums, new ArrayList<>(), 0);
            return res;
        }

        private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> curSubset, int start) {
            res.add(new ArrayList<>(curSubset));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                curSubset.add(nums[i]);
                backtracking(res, nums, curSubset, i + 1);
                curSubset.remove(curSubset.size() - 1);
            }
        }
    }
}

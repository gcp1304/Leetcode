package com.chandra.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Problem_78 {
    public static class Solution_1 {
        //This problem asks us to output all subsets. Every time we add a new valid element into subset,
        // it forms a valid 'subset'. This means that we have to add the subset list in every recursion.
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtracking(res, nums, new ArrayList<>(), 0);
            return res;
        }

        private static void backtracking(List<List<Integer>> res, int[] nums, List<Integer> curSubset, int start) {
            res.add(new ArrayList<>(curSubset));
            for (int i = start; i < nums.length; i++) {
                curSubset.add(nums[i]);
                backtracking(res, nums, curSubset, i + 1);
                curSubset.remove(curSubset.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Problem_78.Solution_1.subsets(nums).toString());
    }
}

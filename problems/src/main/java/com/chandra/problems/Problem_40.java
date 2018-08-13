package com.chandra.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
 * in candidates where the candidate numbers sums to target.

 Each number in candidates may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [10,1,2,7,6,1,5], target = 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 Example 2:

 Input: candidates = [2,5,2,1,2], target = 5,
 A solution set is:
 [
 [1,2,2],
 [5]
 ]
 */

public class Problem_40 {
    public static class Solution_1 {
        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            backtracking(res, candidates, target, new ArrayList<Integer>(), 0);
            return res;
        }

        private static void backtracking(List<List<Integer>> res, int[] candidates, int target, ArrayList<Integer> currentCandidates, int start) {
            if (target == 0) {
                res.add(new ArrayList<>(currentCandidates));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue; // skip using duplicate numbers
                if (candidates[i] <= target) {
                    currentCandidates.add(candidates[i]);
                    backtracking(res, candidates, target - candidates[i], currentCandidates, i + 1);
                    currentCandidates.remove(currentCandidates.size() - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(Problem_40.Solution_1.combinationSum2(arr, target).toString());
    }
}

package com.chandra.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Note:

 All numbers will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: k = 3, n = 7
 Output: [[1,2,4]]
 Example 2:

 Input: k = 3, n = 9
 Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Problem_216 {
    public static class Solution_1 {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            backtracking(k, n, res, new ArrayList<>(), 1);
            return res;
        }

        private void backtracking(int k, int target, List<List<Integer>> res, List<Integer> currList, int start) {
            if (target < 0) return; // just for optimization

            if (target == 0 && currList.size() == k) {
                res.add(new ArrayList<>(currList));
                return;
            }
            for (int i = start; i <= 9; i++) {
                currList.add(i);
                backtracking(k, target - i, res, currList, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem_216.Solution_1 solution_1 = new Solution_1();
        List<List<Integer>> res = solution_1.combinationSum3(3, 7);
    }
}

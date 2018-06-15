package com.chandra.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 */
public class Problem_46 {
    public static class Solution_1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtracking(res, nums, new ArrayList<>());
            return res;
        }

        private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> currPermutation) {
            if (currPermutation.size() == nums.length) {
                res.add(new ArrayList<>(currPermutation));
                return;
            }

            for (int num : nums) {
                if (currPermutation.contains(num))
                    continue; // Skip same value inclusion to prevent duplicate permutations
                currPermutation.add(num);
                backtracking(res, nums, currPermutation);
                currPermutation.remove(currPermutation.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem_46.Solution_1 solution_1 = new Solution_1();
        List<List<Integer>> res = solution_1.permute(new int[]{1,2,3,4});
        for (List<Integer> r : res) {
            System.out.println(r.toString());
        }
    }
}

package com.chandra.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem_39 {
    public static class Solution_1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            backtracking(candidates, target, res, new ArrayList<>(), 0);
            return res;
        }

        private void backtracking(int[] candidates, int target, List<List<Integer>> res, List<Integer> currentList, int start) {
            if (target == 0) res.add(new ArrayList<>(currentList));

            for (int i=start;i<candidates.length;i++) {
                if (candidates[i] <= target) {
                    currentList.add(candidates[i]);
                    backtracking(candidates, target-candidates[i], res, currentList, i); // i is because same candidate can be used again to compute sum
                    currentList.remove(currentList.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem_39.Solution_1 solution_1 = new Solution_1();
        List<List<Integer>> res = solution_1.combinationSum(new int[]{2,3,6,7}, 7);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }

    }
}

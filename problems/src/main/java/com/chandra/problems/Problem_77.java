package com.chandra.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Problem_77 {

    public static class Solution_1 {
        public static List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(n, k, res, new ArrayList<>(), 1); // we start with 1 not from zero since we are not looping through array
            return res;
        }

        private static void backtrack(int n, int k, List<List<Integer>> res, List<Integer> list, int start) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i=start;i<=n;i++) {
                if (list.size() < k) {
                    list.add(i);
                    backtrack(n, k, res, list, i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(Problem_77.Solution_1.combine(n, k).toString());
    }
}

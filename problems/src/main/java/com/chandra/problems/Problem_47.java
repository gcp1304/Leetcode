package com.chandra.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:

 Input: [1,1,2]
 Output:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 */

public class Problem_47 {
    /**
     * The difference between this problem and Permutation is that there are duplicate elements in the input array.
     * Additional work we should do is to skip those duplicate elements after the 1st recursion.

     So, how to skip? Here we use a boolean array called added to keep track of which element has been added
     to the curPerm list. Consider two elements with identical value, if the former one hasn't been added to curPerm,
     then adding the later one to curPerm would reault in duplicate subsets in res list.
     (Since we are visting the elements in order, at the moment we visit the later element, all valid subsets
     containing the former one at the current condition must have already been added to res list).
     Thus we should skip the later duplicate element when its former one has not been added to tmp.

     That is to say, we only add the later duplicate element when the former one has been added to tmp.
     */

    public static class Solution_1 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            boolean[] added = new boolean[nums.length];
            backtracking(res, nums, added, new ArrayList<>());
            return res;
        }

        private void backtracking(List<List<Integer>> res, int[] nums, boolean[] added, List<Integer> curPerm) {
            if (curPerm.size() == nums.length) {
                res.add(new ArrayList<>(curPerm));
                return;
            }

            for (int i=0;i<nums.length;i++) {
                if (added[i] || i > 0 && nums[i] == nums[i-1] && !added[i-1]) continue;
                added[i] = true;
                curPerm.add(nums[i]);
                backtracking(res, nums, added, curPerm);
                curPerm.remove(curPerm.size()-1);
                added[i] = false;
            }
        }
    }
}

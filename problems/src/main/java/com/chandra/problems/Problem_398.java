package com.chandra.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 398. Random Pick Index
 *
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

 Note:
 The array size can be very large. Solution that uses too much extra space will not pass the judge.

 Example:

 int[] nums = new int[] {1,2,3,3,3};
 Solution solution = new Solution(nums);

 // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 solution.pick(3);

 // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 solution.pick(1);

 */

public class Problem_398 {

    public static class Solution_1 {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Random rn = new Random();
        public Solution_1(int[] nums) {
            for (int i=0;i<nums.length;i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new ArrayList<>());
                }
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            return map.get(target).get(rn.nextInt(map.get(target).size()));
        }
    }

    // Resorvoir Sampling
    public static class Solution_2 {

        int[] nums;
        Random rnd;
        public Solution_2(int[] nums) {
            this.nums = nums;
            this.rnd = new Random();
        }

        public int pick(int target) {
            int count = 0;
            int result = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    // this if condition will count the number of occurances and
                    // selects a random number if that's not equal to zero then update result to store current index
                    if (rnd.nextInt(++count) == 0) result = i;
                }
            }

            return result;
        }

    }
}

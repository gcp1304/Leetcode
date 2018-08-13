package com.chandra.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 For example, given array S = [-1, 0, 1, 2, -1, -4],
 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class Problem_15 {

    public static class Solution_1 {
        /* Time Complexity:
            Sort - O(nlogn)
            while loop inside for loop provies O(n*n)

            Total = O(nlogn) + O(n*n) ~ O(n*n)
         */
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> triplets = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2;i++) {
                if (i > 0 && nums[i] == nums[i - 1]){ // this is to avoid duplicate triplets
                    continue;
                }
                int left = i+1;
                int right = nums.length-1;
                while (left < right) {
                    int twoSum = nums[left] + nums[right];
                    int threeSum = nums[i] + twoSum;
                    if (threeSum == 0) triplets.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    else if (threeSum > 0) right--;
                    else left++;
                }
            }

            return triplets;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> triplet : Solution_1.threeSum(nums)) {
            System.out.println(triplet.toString());
        }
    }

}

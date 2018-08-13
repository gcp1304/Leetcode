package com.chandra.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:

 The solution set must not contain duplicate quadruplets.

 Example:

 Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]

 */
public class Problem_18 {

    // 2Sum + 3Sum
    public static class Solution {
        // Time : O(n^2)
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return quadruplets;
            }
            Arrays.sort(nums);

            for (int i=0;i<nums.length-3;i++) {
                if (i > 0 && nums[i] == nums[i-1]) continue; // to avoid duplicate quadruplets

                for (int j = i+1; j < nums.length - 2; j++) {
                    if (j > i+1 && nums[j] == nums[j-1]) continue; // to avoid duplicate quadruplets

                    int left = j+1;
                    int right = nums.length-1;
                    while(left < right) {
                        // below declarations can be written in 1 line.
                        int twoSum = nums[left] + nums[right];
                        int threeSum = nums[j] + twoSum;
                        int fourSum = nums[i] + threeSum;


                        if (fourSum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left + 1 < right && nums[left] == nums[left+1]) left++; //ignoring duplicate inputs
                            while (right-1 > left && nums[right] == nums[right-1]) right--; // ignoring duplicate inputs
                            left++;
                            right--;

                        }

                        else if (fourSum > target) right--;
                        else left++;
                    }
                }
            }

            return quadruplets;

        }
    }

    public static class Solution_1 {
        /*
        The key idea is using backtracking. But before each step, I checked the eligibility of i-th element
        in the array before adding it to the subset list. Basically a lower and an upper boundaries were added to each backtracking step.
         */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            generate(result, new ArrayList<>(), nums, 0, 0, target);
            return result;
        }

        private void generate(List<List<Integer>> result, List<Integer> interimResult, int[] nums, int start, int sum, int target) {
            if (sum == target && interimResult.size() == 4 && !result.contains(interimResult)) {
                result.add(new ArrayList<>(interimResult));
                return;
            } else if (interimResult.size() == 4) return;

            for (int i = start; i < nums.length; i++) {
                if (nums[i] + nums[nums.length - 1] * (3 - interimResult.size()) + sum < target) continue;
                if (nums[i] * (4 - interimResult.size()) + sum > target) return;
                interimResult.add(nums[i]);
                generate(result, interimResult, nums, i + 1, sum + nums[i], target);
                interimResult.remove(interimResult.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        for (List<Integer> quadruplet : Solution.fourSum(nums, target)) {
            System.out.println(quadruplet.toString());
        }
    }
}

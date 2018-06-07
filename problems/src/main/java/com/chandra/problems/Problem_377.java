package com.chandra.problems;

/**
 * 377. Combination Sum IV
 *
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 Example:
 nums = [1, 2, 3] target = 4
 The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
 Note that different sequences are counted as different combinations.
 Therefore the output is 7.
 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?
 */

public class Problem_377 {


    /*
    The original question: a relatively simple DP, the initialization is result[0] = 1; the transfer formula is result[i] += result[i - num].
This question is the fourth line of the combination sum series. I began to take it for granted. The result was written out to find TLE. Indeed, OJ gave a test case of [4,1,2] 32. The result is 39,882,198. Using recursion requires several seconds of computation time. It is not efficient. It is estimated that it is only for returning a sum instead of returning to all situations, otherwise the machine will burst. The real solution to this problem is to use DP. The problem solving concept is a bit like the previous problem Climbing Stairs. We need a one-dimensional array dp, where dp[i] represents the solution of the target number i. The number, then we traverse from 1 to target, for each number i, iterate through the nums array if i>=x, dp[i] += dp[i - x]. This is also well understood, for example for [1,2,3] 4. In this example, when we calculate dp[3], 3 can be split into 1+x, and x is dp[2]. 3 can also be split into 2+x, where x is dp[1], 3 can also be split into 3+x, where x is dp[0], and we add all the cases together to make up all the cases of 3. The
Follow up：
Add a visite, a number can only be used once
I think if there are negative numbers in the array, we must add a requirement that each number is only used one time, or either positive number or negative number should be used only one time, otherwise there would be infinite possible combinations. For example, we are given:
{1, -1}, target = 1,
it's obvious to see as long as we choose n 1s and (n-1) -1s, it always sums up to 1, n can be any value >= 1.
I don't think recursion will work if we don't add any extra requirement. Basically, DP is to memorize the results of sub-problems, which is exactly what recursion will re-calculate instead. They are substantially the same. So if one of the them is not working, neither is the other.
For this problem itself, still use the {-1, 1} example, if we can use any number more than one time, it actually equals to we are given {all negative integers, 0, all positive integers}, ie we are given an array with infinite length because -1 can be used to compose all negative integers and similarly for 1. So there will be infinite number of combinations.

     */
    public static class Solution_1 {
        public int combinationSum4(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] result = new int[target + 1];
            result[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (num <= i) {
                        result[i] += result[i - num];
                    }
                }
            }
            return result[target];
        }
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] nums = new int[]{1,2,3};
        int target = 4;
        System.out.println(solution_1.combinationSum4(nums, target));
    }
}

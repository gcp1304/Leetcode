package com.chandra.problems;

/**
 * 334. Increasing Triplet Subsequence
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 Examples:
 Given [1, 2, 3, 4, 5],
 return true.
 Given [5, 4, 3, 2, 1],
 return false.
 */

public class Problem_334 {

    public static class Solution_1 {
        /**
         * Time: O(n)
         * Space: O(1)
         */
        public boolean increasingTriplet(int[] nums) {
            int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
            for(int num : nums){
                if(num <= min)      min = num; // important
                else if(num <= secondMin)    secondMin = num;// important
                else    return true;
            }
            return false;
        }
    }

    public static class Solution_2 {
        /**Time: O(n^2)
         * Space: O(1)*/
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int firstMin = nums[0];
            int secondMin = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                firstMin = Math.min(firstMin, nums[i-1]); // Determine first min element
                if (nums[i] > firstMin) {
                    secondMin = Math.min(secondMin, nums[i]); // determin second min element
                    for (int j = i+1; j < nums.length; j++) {
                        if (nums[j] > firstMin && nums[j] > secondMin) return true; // check with rest of the array element for 3rd increasing element and return true when found
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,5,0,4,6};
        System.out.println(new Solution_2().increasingTriplet(input));
    }
}

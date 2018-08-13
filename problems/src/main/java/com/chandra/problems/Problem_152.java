package com.chandra.problems;

/**
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

 Example 1:

 Input: [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.
 Example 2:

 Input: [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */

public class Problem_152 {
    public static class Solution_1 {
        public int maxProduct(int[] nums) {
            /*
            We know if we multiply two numbers, the product will be big if the numbers are both big in magnitude and are of same sign.

    Two large negative numbers produce a large positive product
Two large positive numbers produce a large positive product
A large positive and a large negative number produce a large negative product (which may or may not be used further with another negative number to produce a large positive product)
Thus, to find the maximum product in a subarray, we have to keep track of both local minimum product as well as local maximum product.
             */
            int localMax = nums[0];
            int localMin = nums[0];
            int maxProd = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    // we swap localMin and localMax if current number is less than zero
                    // since localmin can be negative and multiplying by negative number would yield bigger number
                    int temp = localMax;
                    localMax = localMin;
                    localMin = temp;
                }

                localMax = Math.max(nums[i], localMax * nums[i]);
                localMin = Math.min(nums[i], localMin * nums[i]);

                maxProd = Math.max(localMax, maxProd);
            }

            return maxProd;
        }
    }

    public static void main(String[] args) {
        Problem_152.Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.maxProduct(new int[]{2,3,-2,4}));
    }
}

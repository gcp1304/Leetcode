package com.chandra.problems;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Image Link -> https://leetcode.com/problems/trapping-rain-water/description/

 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 */

public class Problem_42 {
    public static class Solution_1 {

        /**
         *
         * Find maximum height of bar from the left end upto an index i in the array left_max.
         * Find maximum height of bar from the right end upto an index i in the array right_max.
         *
         * Iterate over the height array and update ans:
         *  Add min(leftMax[i],rightMax[i])−height[i] to ans
         *
         *  Time Complexity: O(n)
         *
         *  We store the maximum heights upto a point using 2 iterations of O(n) each.
         *  We finally update ans using the stored values in O(n).
         */

        public int trap(int[] height) {
            int leftMax[] = new int[height.length];
            int rightMax[] = new int[height.length];

            int ans = 0;

            leftMax[0] = height[0];
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i-1]);
            }

            rightMax[height.length - 1] = height[height.length - 1];
            for (int i = height.length-2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i], rightMax[i+1]);
            }

            for (int i=1;i<height.length-1;i++) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Problem_42.Solution_1 solution_1 = new Solution_1();

        System.out.println(solution_1.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // 6
    }
}

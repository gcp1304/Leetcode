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


        /*
        Visualize this
        Case 1: You have only 2 buildings, the amount of water that can be trapped between 2 buildings depends on the smaller height building

        Case 2: You have 3 buildings, imagine

            left building of height - 4
            middle building of height - 2
            right building of height - 6

            Now the amount of water that can be trapped is
            a. since left building height is 4 and right build height is 6, then water is 4
            b. since there's a building in the middle of height 2, so we remove height 2 from 4 of point a then we are left with 2 which is the result

            The below diagram is not that elegant but just gives an idea of above case 2 explaination
              |
              |
            |_|
            |_|
            |||
            |||


            Last word is all we have to find out is how much of water is trapped on top of the buildings when all the buildings are attached to each other with different heights

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

        System.out.println(solution_1.trap(new int[]{4,2,6})); // 6
    }
}

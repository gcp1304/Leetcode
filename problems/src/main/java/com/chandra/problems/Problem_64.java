package com.chandra.problems;

/**
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:

 Input:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class Problem_64 {
    public static class Solution_1 {
        // Recursive - TLE
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            return helper(grid, 0, 0);
        }

        private int helper(int[][] grid, int row, int col) {
            if (row == grid.length-1 && col == grid[0].length-1)
                return grid[row][col];

            if (row >= grid.length || col >= grid[0].length)
                return Integer.MAX_VALUE;

            return grid[row][col] + Math.min(helper(grid, row+1, col), helper(grid, row, col+1));
        }
    }

    public static class Solution_2 {
        // DP
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;

            for (int i=0;i<grid.length;i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j != 0) grid[i][j] += grid[i][j-1];
                    else if (i!=0 && j == 0) grid[i][j] += grid[i-1][j];
                    else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }

            return grid[grid.length-1][grid[0].length-1];
        }
    }

}

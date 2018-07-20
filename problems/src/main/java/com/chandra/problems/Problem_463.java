package com.chandra.problems;

/**
 * 463. Island Perimeter
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 Example:

 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 Answer: 16
 Explanation: The perimeter is the 16 yellow stripes in the image below:


 */
public class Problem_463 {
    public static class Solution_1 {
        // Add 4 sides and remove edge if it's a island
        public int islandPerimeter(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int sides = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        sides = sides + 4
                                - (i > 0 ? grid[i - 1][j] : 0) // check for top
                                - (i < grid.length-1 ? grid[i + 1][j] : 0) // check right
                                - (j > 0 ? grid[i][j - 1] : 0) // check left
                                - (j < grid[0].length-1 ? grid[i][j + 1] : 0);
                    }
                }
            }

            return sides;
        }
    }

    public static class Solution_2 {
        //add 4 for each land and remove 2 for each internal edge
        /**Inspired by this post: https://discuss.leetcode.com/topic/68983/java-9-line-solution-add-4-for-each-land-and-remove-2-for-each-internal-edge
         * 1. we increment the count by 4 whenever we encounter an island
         * 2. also, we check in two directions: island's left and island's top, we only check these two directions,
         * see if this island has any island neighbors, if so, we'll deduct two from it.*/

        public int islandPerimeter(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
            int sides = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        sides += 4;
                    }

                    if (i > 0 && grid[i - 1][j] == 1) sides -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) sides -= 2;
                }
            }
            return sides;
        }
    }
}

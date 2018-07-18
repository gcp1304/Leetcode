package com.chandra.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 417. Pacific Atlantic Water Flow
 *
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:
 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.
 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class Problem_417 {
    /**
     * Think of this problem as similar to Number of Islands problem
     *
     * The idea is as following:

     First, we can separate Pacific and Atlantic ocean into two, they share the same idea.
     The only difference is the starting position.

     Second, we think this problem in the opposite way: all the valid positions must have at
     least one path to connect to the ocean, so we start from the ocean to find out all the paths.

     Then we create a new boolean[][] matrix which will hold all the paths from each beach to the ocean satisfying the given constraints
     The idea is the same for Pacific and Atlantic.

     The last step is to use && to find positions satisfy both Pacific and Atlantic.
     */
    public static class Solution_1 {
        public static List<int[]> pacificAtlantic(int[][] matrix) {
            List<int[]> result = new ArrayList<>();

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

            boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
            boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];


            // Row wise for both oceans to determine paths from beach to ocean
            for (int i = 0; i < matrix.length; i++) {
                explore(matrix, i, 0, pacific, -1);
                explore(matrix, i, matrix[0].length-1, atlantic, -1);
            }

            // Column wise for both oceans to determine paths from beach to ocean
            for (int j = 0; j < matrix[0].length; j++) {
                explore(matrix, 0, j, pacific, -1);
                explore(matrix, matrix.length-1, j, atlantic, -1);
            }

            // Now check if there's a common path for beaches to both the ocean which is what we are looking for
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        result.add(new int[]{i, j});
                    }
                }
            }

            return result;
        }

        private static void explore(int[][] matrix, int i, int j, boolean[][] ocean, int neighborHeight) {
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && !ocean[i][j] && neighborHeight <= matrix[i][j]) {
                ocean[i][j] = true;
                explore(matrix, i+1, j, ocean, matrix[i][j]);
                explore(matrix, i-1, j, ocean, matrix[i][j]);
                explore(matrix, i, j+1, ocean, matrix[i][j]);
                explore(matrix, i, j-1, ocean, matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        System.out.println(Arrays.deepToString(Problem_417.Solution_1.pacificAtlantic(input).toArray()));
    }
}

package com.chandra.problems;

/**
 * 240. Search a 2D Matrix II
 *
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 Example:

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
public class Problem_240 {
    public static class Solution_1 {
        public boolean searchMatrix(int[][] matrix, int target) {

            if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
                return false;
            }


            if (target < matrix[0][0]) return false;
            if (target > matrix[matrix.length-1][matrix[0].length-1]) return false;
            if (target == matrix[0][0] || target == matrix[matrix.length-1][matrix[0].length-1]) return true;

            // start from top right
            int row = 0;
            int col = matrix[0].length-1;

            while(col >= 0 && row <= matrix.length-1) {
                if (target == matrix[row][col]) return true;
                if (target < matrix[row][col]) col--;
                else row++;
            }

            return false;
        }
    }
}

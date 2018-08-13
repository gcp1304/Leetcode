package com.chandra.problems;

/**
 * 73. Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

 Example 1:

 Input:
 [
 [1,1,1],
 [1,0,1],
 [1,1,1]
 ]
 Output:
 [
 [1,0,1],
 [0,0,0],
 [1,0,1]
 ]
 Example 2:

 Input:
 [
 [0,1,2,0],
 [3,4,5,2],
 [1,3,1,5]
 ]
 Output:
 [
 [0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]
 ]
 Follow up:

 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?

 */
public class Problem_73 {
    public static class Solution_1 {
        /*
        The idea here is
        1. Identify if either first row or col has zero and save the state accordingly
        2. Now start from 2nd row, 2nd col.
            a. whenever you encounter 0 cell, then just update the previous cells in that row and col to zero.
            b. if we encounter a cell which is non-zero, then check for zero in the first cell in that col or row, if present then update the current cell to zero
        3. Finally fill in the first row and first col based on the state saved earlier
         */
        public void setZeroes(int[][] matrix) {
            boolean isFirstRowZero = false, isFirstColumnZero = false;
            int rows = matrix.length, cols = matrix[0].length;
            for (int i=0;i<rows;i++) {
                if (matrix[i][0] == 0) {
                    isFirstColumnZero = true;
                    break;
                }
            }

            for (int j=0;j<cols;j++) {
                if (matrix[0][j] == 0) {
                    isFirstRowZero = true;
                    break;
                }
            }

            for (int i=1;i<rows;i++) {
                for (int j=1;j<cols;j++) {
                    if (matrix[i][j] == 0)
                        setZeroes(matrix, i, j);
                    else if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
                }
            }

            if (isFirstRowZero)
                for (int i=0;i<cols;i++) matrix[0][i] = 0;

            if (isFirstColumnZero)
                for (int j=0;j<rows;j++) matrix[j][0] = 0;
        }

        // This helper function update the cells above and left to the current cell to zero
        private void setZeroes(int[][] matrix, int row, int col) {
            for (int i=0;i<row;i++)
                matrix[i][col] = 0;

            for (int j=0;j<col;j++)
                matrix[row][j] = 0;
        }
    }
}

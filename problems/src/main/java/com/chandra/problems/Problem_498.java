package com.chandra.problems;

import java.util.Arrays;

/**
 * 498. Diagonal Traverse
 *
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 Example:
 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output:  [1,2,4,7,5,3,6,8,9]
 Explanation:

 Note:
 The total number of elements of the given matrix will not exceed 10,000.
 */
public class Problem_498 {
    public static class Solution_1 {
        public static int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[0];
            int rows = matrix.length, cols = matrix[0].length;
            int row = 0, col = 0;
            int[] ans = new int[rows*cols];

            for (int i=0;i<ans.length;i++) {
                ans[i] = matrix[row][col];

                if ((row + col) % 2 == 0) { // all even going up
                    if (col == cols-1) row++;
                    else if (row == 0) col++;
                    else {
                        row--;
                        col++;
                    }
                } else { // all odd -> going down
                    if (row == rows-1) col++;
                    else if (col == 0) row++;
                    else {
                        row++;
                        col--;
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println(Arrays.toString(Solution_1.findDiagonalOrder(matrix)));
    }
}

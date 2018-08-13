package com.chandra.problems;

/**
 * 59. Spiral Matrix II
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 Example:

 Input: 3
 Output:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 */
public class Problem_59 {
    // Exactly similar Problem_54 but the only difference here is
    // instead of reading from matrix you fill up matrix
    public static class Solution_1 {
        public int[][] generateMatrix(int n) {
            int count = 1;
            int top = 0, bottom = n-1;
            int left = 0, right = n-1;
            int[][] matrix = new int[n][n];

            while(true) {
                // Go right
                for (int i=left;i<=right;i++)
                    matrix[top][i] = count++;
                top++;
                if (top > bottom) break;

                // go down
                for (int i=top;i<=bottom;i++)
                    matrix[i][bottom] = count++;
                right--;
                if (right < left) break;

                // go left
                for (int i=right; i>=left;i--)
                    matrix[bottom][i] = count++;
                bottom--;
                if (bottom < top) break;

                // go up
                for (int i=bottom;i>=top;i--)
                    matrix[i][left] = count++;
                left++;
                if (left > right) break;

            }

            return matrix;
        }
    }
}

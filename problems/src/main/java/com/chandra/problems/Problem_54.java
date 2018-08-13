package com.chandra.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 Example 1:

 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output: [1,2,3,6,9,8,7,4,5]
 Example 2:

 Input:
 [
 [1, 2, 3, 4],
 [5, 6, 7, 8],
 [9,10,11,12]
 ]
 Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Problem_54 {
    public static class Solution_1 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> spiral = new ArrayList<>();

            if (matrix == null || matrix.length == 0) return spiral;

            int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;

            while(true) {
                // go right
                for (int i=left;i<=right;i++)
                    spiral.add(matrix[top][i]);
                top++;
                if (top > bottom) break;

                // go down
                for (int i=top;i<=bottom;i++)
                    spiral.add(matrix[i][right]);
                right--;
                if (right<left) break;

                // go left
                for (int i=right;i>=left;i--)
                    spiral.add(matrix[bottom][i]);
                bottom--;
                if (bottom < top) break;

                // go up
                for (int i=bottom;i>=top;i--)
                    spiral.add(matrix[i][left]);
                left++;
                if (left > right) break;
            }

            return spiral;
        }
    }
}

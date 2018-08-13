package com.chandra.problems;

/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 Note: m and n will be at most 100.

 Example 1:

 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 Example 2:

 Input: m = 7, n = 3
 Output: 28

 */
public class Problem_62 {
    /**
     * First thing first -- you should first try to solve it recursively. The reason is that the recursion clearly
     * demonstrates what the problem is. The approach should be to come up with a recursive equation and then use
     * that to solve it first. The optimization using DP should come later.
     So, to solve using recursion, the question is: how many ways one could reach to the last cell (with the finish)?
     It is the sum of number of ways you could reach to the cell above, and the cell to the left.
     Putting it into an equation, here it is :
     T(m)(n) = T(m-1)(n) + T(m)(n-1).

     The first condition takes care of index going out of scope and when you reach to the first cell,
     it completes one path. Rest is merely recursive call.
     */
    public static class Solution_1 {
        // Recursive
        public int uniquePaths(int m, int n) {
            if (m <=0 || n<=0) {
                return 0;
            } else if (m == 1 && n ==1) {
                return 1;
            }
            return uniquePaths(m-1,n) + uniquePaths(m,n-1);
        }
    }

    /**
     *
     * However, the time complexity of recursive approach tends to be exponential
     * since it will calculate every path again and again. The better way is to use Dynamic Programming
     * keeping the same recursion in our mind. We could simulate it with a 2-D array that uses n * m size and
     * our size lies at the arr [n-1 ][m-1] index. Also, remember that for all values of m, arr[0][m] will be 1
     * since there is only 1 way to go on the right side. Likewise, for all values of n, arr[n][0] will be 1 since
     * there is only 1 way to go down. With that in the mind, here is the code:


     */
    public static class Solution_2 {
        // Dynamic Programming
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[n][m];
            /*Arrays.fill(dp[0],1);
            for (int i = 0;i<n;i++) {
                dp[i][0] = 1;
            }*/

            dp[0][1] = 1;

            for (int i=1;i<n ; i++) {
                for (int j=1;j<m;j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            return dp[n-1][m-1];
        }
    }
}

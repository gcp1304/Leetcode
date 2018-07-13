package com.chandra.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 542. 01 Matrix
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.
 Example 1:
 Input:

 0 0 0
 0 1 0
 0 0 0
 Output:
 0 0 0
 0 1 0
 0 0 0
 Example 2:
 Input:

 0 0 0
 0 1 0
 1 1 1
 Output:
 0 0 0
 0 1 0
 1 2 1
 Note:
 The number of elements of the given matrix will not exceed 10,000.
 There are at least one 0 in the given matrix.
 The cells are adjacent in only four directions: up, down, left and right.

 */
public class Problem_542 {
    // Time - O(r.c), space - O(r⋅c). Additional O(r⋅c) for queue
    /*
    Intuition

A better brute force: Looking over the entire matrix appears wasteful and hence, we can use Breadth First Search(BFS)
 to limit the search to the nearest 0 found for each 1. As soon as a 0 appears during the BFS,
 we know that the 0 is nearest, and hence, we move to the next 1.

Think again: But, in this approach, we will only be able to update the distance of one 1 using one BFS,
which could in fact, result in slightly higher complexity than the Approach #1 brute force. But hey,this
could be optimised if we start the BFS from 0s and thereby, updating the distances of all the 1s in the path.

Algorithm

For our BFS routine, we keep a queue, q to maintain the queue of cells to be examined next.
We start by adding all the cells with 0s to q.
Intially, distance for each 0 cell is 0 and distance for each 1 is INT_MAX, which is updated during the BFS.
Pop the cell from queue, and examine its neighbours. If the new calculated distance for neighbour {i,j} is smaller, we add {i,j} to q and update dist[i][j].
     */
    public static class Solution_1 {
        /*
        The idea here is first check all the cells whose value is zero and add it to queue.
        Now for every zero cell check their neighbors in all 4 directions, whenever neighbor cell value is large which means neighbor is closest for farthest 1
        hence update the neighbor cell with 1 more than current cell and add the neighbor cell to queue to process it's neighbors and update there distance to 1 respectively.

        Since we will be processing level by level (hence idea is BFS) meaning first zero distance, next 1 distance, next 2 distance and so on.

        After we complete visiting all the cells with 1 and their neighbors whose distances got updated we return the matrix which will have a final result.


        the first procedure ,there are two states vaule of the cells,they are 0,or integer.MAX_VLUE,and
        the cell of value 0 have been added to the queue,in the next stage ,all the cell valued Integer.MAX_VALUE will be added to the queue individually,
        in the end ,after the queue is empty,all the cell got their correct value ,
         */
        public int[][] updateMatrix(int[][] matrix) {
            // BFS
            Queue<int[]> queue = new LinkedList<>();
            int rows = matrix.length;
            int cols = matrix[0].length;

            // Keep track of all zero's and change others to Int.MAX
            // Store each position of zero value to queue
            for (int row=0;row<rows;row++) {
                for (int col=0;col<cols;col++) {
                    if (matrix[row][col] == 0) {
                        queue.offer(new int[]{row, col});
                    } else {
                        matrix[row][col] = Integer.MAX_VALUE;
                    }
                }
            }

            // Neighbors directions of each node
            int[][] directions = {/*top*/{-1, 0}, /*left*/{0, -1}, /*bottom*/{1, 0}, /*right*/{0, 1}};

            while (!queue.isEmpty()) {
                int[] currentCell = queue.poll();
                for (int[] direction : directions) {
                    int neighborRow = currentCell[0] + direction[0];
                    int neighborCol = currentCell[1] + direction[1];

                    // Skip if neighbors are out of bounds
                    // or if neighbor value <= current cell value + 1, since neighbor is closest other zero
                    if (neighborRow < 0 || neighborRow >= rows || neighborCol < 0 || neighborCol >= cols ||
                            matrix[neighborRow][neighborCol] <= matrix[currentCell[0]][currentCell[1]] + 1 ) continue;
                    queue.offer(new int[]{neighborRow, neighborCol});
                    matrix[neighborRow][neighborCol] = matrix[currentCell[0]][currentCell[1]] + 1;
                }
            }

            return matrix;
        }
    }

    public static class Solution_2 {
        /**
         * Intuition - DP

         The distance of a cell from 0 can be calculated if we know the nearest distance for all the neighbours,
         in which case the distance is minimum distance of any neightbour + 1. And, instantly, the word come to mind DP!!
         For each 1, the minimum path to 0 can be in any direction. So, we need to check all the 4 direction.
         In one iteration from top to bottom, we can check left and top directions, and we need another iteration
         from bottom to top to check for right and bottom direction.

         Algorithm

         Iterate the matrix from top to bottom-left to right:
         Update dist[i][j]=min(dist[i][j],min(dist[i][j−1],dist[i−1][j])+1) i.e., minimum of the current dist and
         distance from top or left neighbour +1, that would have been already calculated previously in the current iteration.

         Now, we need to do the back iteration in the similar manner: from bottom to top-right to left:
         Update dist[i][j]=min(dist[i][j],min(dist[i][j+1],dist[i+1][j])+1) i.e. minimum of current dist and
         distances calculated from bottom and right neighbours, that would be already available in current iteration.

         */
        public int[][] updateMatrix(int[][] matrix) {
            int rows = matrix.length;
            if (rows == 0) return matrix;

            int cols = matrix[0].length;
            int[][] distance = new int[rows][cols];
            for (int[] row : distance) {
                Arrays.fill(row, Integer.MAX_VALUE - 100000); // subtracting to avoid integer overflow when add +1 to distance
            }

            // Top to bottom -> left to right
            for (int row = 0;row<rows;row++) {
                for (int col=0;col<cols;col++) {
                    if (matrix[row][col] == 0) {
                        distance[row][col] = 0;
                    } else {
                        if (row > 0) {
                            distance[row][col] = Math.min(distance[row][col], distance[row-1][col] + 1); // Top
                        }

                        if (col > 0) {
                            distance[row][col] = Math.min(distance[row][col], distance[row][col - 1] + 1); // left
                        }
                    }
                }
            }

            // Bottom to Top -> Right to left
            for (int row = rows-1;row >= 0; row--) {
                for (int col=cols-1; col >= 0; col--) {
                    if (row < rows-1) {
                        distance[row][col] = Math.min(distance[row][col], distance[row+1][col] + 1); // bottom
                    }

                    if (col < cols-1) {
                        distance[row][col] = Math.min(distance[row][col], distance[row][col+1] + 1); // right
                    }
                }
            }

            return distance;
        }
    }
}

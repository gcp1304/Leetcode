package com.chandra.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. Trapping Rain Water II
 *
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

 Note:
 Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

 Example:

 Given the following 3x6 height map:
 [
 [1,4,3,1,3,2],
 [3,2,1,3,2,4],
 [2,3,3,2,3,1]
 ]

 Return 4.
 */

public class Problem_407 {

    /**
     * 1. We ignore all the buildings in the border by marking them as visited
     * 2. At the same time we store all the visited building heights in PQ (lowest building to tallest building)
     * 3. Now start with the smallest building
     * 4. If building is already visited check unvisited neighbors
     * 5. whenever we encounter unvisited neighbor
     *  5a. we determine the take the height difference compared to current cell with neighbor cell, which will give how much water is
     *  trapped on that building
     *  5b. Now store the visited neighbor into PQ with height of max building (i.e max among current building and neighbor building)
     */

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] c1, int[] c2) {
                return c1[2] - c2[2];
            }
        });

        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (i==0||j==0||i==rows-1||j==cols-1) {
                    visited[i][j] = true;
                    pq.add(new int[]{i, j, heightMap[i][j]});
                }
            }
        }

        int waterTrapped = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            for (int[] dir : dirs) {
                int nx = dir[0] + cell[0];
                int ny = dir[1] + cell[1];
                if (nx >=0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    waterTrapped += Math.max(0, cell[2] - heightMap[nx][ny]);
                    pq.add(new int[]{nx, ny, Math.max(heightMap[nx][ny], cell[2])});
                }
            }
        }

        return waterTrapped;
    }



    public static void main(String[] args) {
        int[][] height = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };

        System.out.println(Problem_407.trapRainWater(height));
    }
}

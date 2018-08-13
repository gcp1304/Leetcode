package com.chandra.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.MAX_VALUE;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
    a) -1 -> A wall or an obstacle.
    b) 0 -> A gate.
    c) INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.

 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 */
public class Problem_286 {

    public static class Solution_1 {
        // DFS Solution
        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0) return;
            
            int rows = rooms.length;
            int cols = rooms[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rooms[i][j] == 0) {
                        fill(rooms, rows, cols, i, j, 0);
                    }
                }
            }
        }

        private void fill(int[][] rooms, int rows, int cols, int i, int j, int distance) {

            // If row or col is outside of grid then return
            if (i < 0 || i >= rows || j < 0 || j >= cols || rooms[i][j] < distance) return;

            // Is wall?
            if (rooms[i][j] == -1) return;

            // update distance
            rooms[i][j] = distance;

            // go up, down, left, and right
            fill(rooms, rows, cols, i-1, j, distance+1);
            fill(rooms, rows, cols, i+1, j, distance+1);
            fill(rooms, rows, cols, i, j-1, distance+1);
            fill(rooms, rows, cols, i, j+1, distance+1);
        }
    }

    public static class Solution_2 {
        // DFS with visited state
        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0) return;

            int rows = rooms.length;
            int cols = rooms[0].length;

            boolean[][] visited = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rooms[i][j] == 0) {
                        fill(rooms, visited, rows, cols, i, j, 0);
                    }
                }
            }
        }

        private void fill(int[][] rooms, boolean[][] visited, int rows, int cols, int i, int j, int distance) {

            // If row or col is outside of grid then return
            if (i < 0 || i >= rows || j < 0 || j >= cols) return;

            // if cell is already visited
            if (visited[i][j]) return;

            // Is wall?
            if (rooms[i][j] == -1) return;

            // Distance greater than current
            if (distance > rooms[i][j]) return;

            // Mark as visited
            visited[i][j] = true;

            // update distance
            rooms[i][j] = Math.min(rooms[i][j], distance);

            // go up, down, left, and right
            fill(rooms, visited, rows, cols, i-1, j, distance+1);
            fill(rooms, visited, rows, cols, i+1, j, distance+1);
            fill(rooms, visited, rows, cols, i, j-1, distance+1);
            fill(rooms, visited, rows, cols, i, j+1, distance+1);

            // Mark as unvisited for backtracking
            visited[i][j] = false;
        }
    }

    public static class Solution_3 {
        // BFS Solution
        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0) return;

            int rows = rooms.length;
            int cols = rooms[0].length;

            Queue<Integer[]> queue = new LinkedList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rooms[i][j] == 0) {
                        // Add all the gates to queue
                        queue.offer(new Integer[]{i, j});
                    }
                }
            }

            while (!queue.isEmpty()) {
                Integer[] head = queue.poll();
                int row = head[0];
                int col = head[1];

                // Up -> Update and Add to queue empty cell
                if (row > 0 && rooms[row-1][col] == MAX_VALUE) {
                    rooms[row-1][col] = rooms[row][col]+1;
                    queue.offer(new Integer[]{row-1, col});
                }

                // Down
                if (row < rows-1 && rooms[row+1][col] == MAX_VALUE) {
                    rooms[row+1][col] = rooms[row][col] + 1;
                    queue.offer(new Integer[]{row+1, col});
                }

                // Left
                if (col > 0 && rooms[row][col-1] == MAX_VALUE) {
                    rooms[row][col-1] = rooms[row][col]+1;
                    queue.offer(new Integer[]{row, col-1});
                }

                // Right
                if (col < cols-1 && rooms[row][col+1] == MAX_VALUE) {
                    rooms[row][col+1] = rooms[row][col]+1;
                    queue.offer(new Integer[]{row, col+1});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] input1 = new int[][] {
                {MAX_VALUE, -1, 0, MAX_VALUE},
                {MAX_VALUE, MAX_VALUE, MAX_VALUE, -1},
                {MAX_VALUE, -1, MAX_VALUE, -1},
                {0, -1, MAX_VALUE, MAX_VALUE}
        };

        int[][] input2 = new int[][] {
                {MAX_VALUE, -1, 0, MAX_VALUE},
                {MAX_VALUE, MAX_VALUE, MAX_VALUE, -1},
                {MAX_VALUE, -1, MAX_VALUE, -1},
                {0, -1, MAX_VALUE, MAX_VALUE}
        };

        int[][] input3 = new int[][] {
                {MAX_VALUE, -1, 0, MAX_VALUE},
                {MAX_VALUE, MAX_VALUE, MAX_VALUE, -1},
                {MAX_VALUE, -1, MAX_VALUE, -1},
                {0, -1, MAX_VALUE, MAX_VALUE}
        };

        Solution_1 solution_1 = new Solution_1();
        Solution_2 solution_2 = new Solution_2();
        Solution_3 solution_3 = new Solution_3();
        solution_1.wallsAndGates(input1);
        solution_2.wallsAndGates(input2);
        solution_3.wallsAndGates(input3);

        System.out.println(Arrays.deepToString(input1)); // [[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]
        System.out.println(Arrays.deepToString(input2)); // [[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]
        System.out.println(Arrays.deepToString(input3)); // [[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]
    }
}

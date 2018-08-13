package com.chandra.problems;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 378. Kth Smallest Element in a Sorted Matrix
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class Problem_378 {
    public static class Solution_1 {
        public static int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int[] row : matrix) {
                for (int element : row) {
                    pq.offer(element);
                    while (pq.size() > k) pq.poll();
                }
            }

            return pq.peek();
        }

        public static void main(String[] args) {
            int[][] matrix = {
                    {1, 5, 9},
                    {10, 11, 13},
                    {12, 13, 15}
            };
            System.out.println(kthSmallest(matrix, 8)); // 13
        }
    }
}

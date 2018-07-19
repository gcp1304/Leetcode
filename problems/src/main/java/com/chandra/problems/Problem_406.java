package com.chandra.problems;

import java.util.*;


/**
 * 406. Queue Reconstruction by Height
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have
 * a height greater than or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Problem_406 {

    /**
     * Algorithm
     * 1. Build a max heap based on height.
     *  1a. When two people have same height, then compare k to place in PQ
     *
     * 2. Build a list based on k as position for list items.
     * 3. Now build a 2D as a result from the list and return
     */

    public static class Solution_1 {
        public static int[][] reconstructQueue(int[][] people) {

            // maxheap to hold list of people in comparison with height and then use k to order the same height people
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
                }
            });

            for (int[] person : people) {
                pq.offer(person);
            }

            List<int[]> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                int[] person = pq.poll();
                list.add(person[1], person);
            }

            return list.toArray(people);
        }
    }

    public static class Solution_2 {
        public static int[][] reconstructQueue(int[][] people) {

            if(people == null || people.length == 0 || people[0].length == 0)
                return new int[0][0];
            // We sort the original array using comparator and then loop through each item to build a list
            // Important - Anonymous function runs much faster than lambda
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
                }
            });
            List<int[]> list = new ArrayList<>();
            for (int[] person : people) {
                list.add(person[1], person);
            }
            return list.toArray(people);
        }

        private static class myComp implements Comparator<int[] >{
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                    return a[1] - b[1];
                else
                    return b[0] - a[0];

            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        System.out.println(Arrays.deepToString(Solution_1.reconstructQueue(input)));
        System.out.println(Arrays.deepToString(Solution_2.reconstructQueue(input)));
    }
}

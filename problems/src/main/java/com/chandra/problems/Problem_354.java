package com.chandra.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 354. Russian Doll Envelopes

 You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Note:
 Rotation is not allowed.

 Example:

 Input: [[5,4],[6,4],[6,7],[2,3]]
 Output: 3
 Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class Problem_354 {
    public static class Solution_1 {

        /*
If you sort the width in ascending order and the height in descending order, this problem is same with no.300.
For example, here are some envelops [2, 6] [3, 3] [3, 6] [2, 3] [1,1] [2 ,4].
After sorted, the evnelops become [1, 1] [2, 6] [2 ,4] [2, 3] [3, 6] [3, 3].
In this way, we focus on height of this array [1, 6, 4, 3, 6, 3] and find the longest increasing subsequence.
         */
        public static int maxEnvelopes(int[][] envelopes) {

            if (envelopes == null || envelopes.length == 0) return 0;

            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
                }
            });

            int[] dp = new int[envelopes.length];
            int len = 0;
            for(int[] envelope : envelopes) {
                // binary search on height for each envelope
                int idx = Arrays.binarySearch(dp, 0, len, envelope[1]); // return idx of height if present with in given range from 0 to len
                // or returns the insertion point from binary search
                if (idx < 0) idx = -idx-1; // if idx is negative which means then it's an insertion point, hence convert it to valid idx as
                // per Java documentation https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch(int[],%20int)

                dp[idx] = envelope[1];
                if (len == idx) len++; //if our insertion point is equal to len then increment len because we are inserting new element

            }

            System.out.println(Arrays.toString(dp));

            return len;
        }
    }

    public static void main(String[] args) {
        int[][] envelopes = {
            {5,4},
            {6,4},
            {6,7},
            {2,3}
        };

        System.out.println(Solution_1.maxEnvelopes(envelopes));
    }


}

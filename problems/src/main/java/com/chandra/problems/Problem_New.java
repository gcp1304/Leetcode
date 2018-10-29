package com.chandra.problems;


import java.util.Arrays;

/**
 * Minimum number of tokens
 * <p>
 * There are N people standing in a line. Each person is assigned a rank.
 *
 * You are handing out tokens to people standing in line subjected to following conditions
 *
 * 1. Every person must receive at least one token
 * 2. Person with higher ranks gets more tokens than their neighbors
 *
 * What is the minimum number of tokens you need to handout?
 *
 * E.g: Input : [2, 4, 6, 7, 10, 2]
 * Output: 16
 *
 *
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third person with 1, 2, 1 tokens respectively.
 * The third person gets 1 token because it satisfies the above two conditions.
 */
public class Problem_New {
    public static class Solution_1 {
        // Time - O(n)
        //https://leetcode.com/problems/candy/solution/
        public static int minimumNumberOfTokens(int[] ranks) {
            int minTokens = 0;
            if (ranks == null || ranks.length == 0) return minTokens;

            int[] tokens = new int[ranks.length];
            Arrays.fill(tokens, 1);
            for (int i = 1; i < ranks.length; i++) {
                if (ranks[i] > ranks[i - 1]) tokens[i] = tokens[i - 1] + 1;
            }

            minTokens = tokens[ranks.length - 1];
            for (int j = ranks.length - 2; j >= 0; j--) {
                if (ranks[j] > ranks[j+1]) {
                    tokens [j] = Math.max(tokens[j], tokens[j+1]+1);
                }
                minTokens += tokens[j];
            }

            return minTokens;
        }

        public static void main(String[] args) {
            int[] ranks = new int[]{1,2,2};
            System.out.println(Solution_1.minimumNumberOfTokens(ranks));
        }
    }
}

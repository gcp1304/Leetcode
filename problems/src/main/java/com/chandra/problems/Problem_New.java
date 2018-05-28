package com.chandra.problems;


import java.util.Arrays;

/**
 * Minimum number of tokens
 * <p>
 * Given an array of unsorted integers, each integer value representing the rank of a person.
 * Write a function that returns the minimum number of tokens you have to give to people in the line depending on the
 * rank of each person satisfying the below conditions
 * <p>
 * 1. Every person must receive at least one token
 * 2. If two people, p1 and p2, are adjacent, and rank(p2)>rank(p1), then p2 must receive more tokens than p1.
 * 3. If two people, p1 and p2, are adjacent, and have rank(p1 = rank(p2), then both p1 and p2 must receive same number of tokens
 * <p>
 * E.g: Input : [2, 4, 6, 7, 10, 2]
 * Output: 16
 * <p>
 * Input : [10, 8, 8, 5, 3, 2]
 * Output: 19
 */
public class Problem_New {
    public static class Solution_1 {
        // Time - O(n)
        public int minimumNumberOfTokens(int[] ranks) {
            int minTokens = 0;
            if (ranks == null || ranks.length == 0) return minTokens;

            int[] tokens = new int[ranks.length];
            //System.out.println("I/P: " + Arrays.toString(ranks));
            Arrays.fill(tokens, 1);
            tokens[0] = 1; // first person
            for (int i = 1; i < ranks.length; i++) {
                if (ranks[i] > ranks[i - 1]) tokens[i] = tokens[i - 1] + 1;
            }

            //System.out.println("L/R: " + Arrays.toString(tokens));


            minTokens += tokens[ranks.length-1];
            for (int j = ranks.length - 2; j >= 0; j--) {
                if (ranks[j] > ranks[j+1]) tokens[j] = tokens[j+1]+1 > tokens[j] ? tokens[j+1]+1 : tokens[j];
                else if (ranks[j] == ranks[j+1]) tokens[j] = tokens[j+1];

                minTokens += tokens[j];
            }

            //System.out.println("R/L: " + Arrays.toString(tokens) + " -> Actual Output");
            System.out.println("Minimum Tokens: " + minTokens);
            return minTokens;
        }
    }
}

package com.chandra.problems;

/**
 * 161. One Edit Distance
 * <p>
 * Given two strings S and T, determine if they are both one edit distance apart.
 */

public class Problem_161 {
    public static class Solution1 {
        public boolean isOneEditDistance(String s, String t) {
            if (s == null || t == null) return false;

            int m = s.length(), n = t.length(), diffCount = 0, i = 0, j = 0;

            if (Math.abs(m - n) > 1) return false;

            while (i < m && j < n) {
                // When both the chars are same
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    diffCount++; // doesn't matter what edit it is, increment the count
                    if (diffCount > 1) return false; // since there more than one edit

                    // If length of one string is greater than other, then possible action is to remove a char
                    if (m > n) i++;
                    else if (n > m) j++;
                    else { // if lengths of both strings is same
                        i++;
                        j++;
                    }

                }
            }

            // if last char is extra in any string
            if (i < m || j < n) {
                diffCount++;
            }

            return diffCount == 1;
        }
    }

    public static class Solution_2 {
        public boolean isOneEditDistance(String s, String t) {
            int len = Math.min(s.length(), t.length());
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (s.length() == t.length()) return s.substring(i+1).equals(t.substring(i+1)); //replace
                    else if (s.length() < t.length()) return s.substring(i).equals(t.substring(i+1)); // delete in t
                    else return s.substring(i+1).equals(t.substring(i)); //delete in s
                }
            }

            return Math.abs(s.length() - t.length()) == 1; // corner case: ""
        }
    }

    public static class Solution_3 {
        /**
         * Dynamic Programming
         *
         * Calculate the total distance between two strings and check if the distance == 1 or not
         */
        public boolean isEditDistanceOne(String s1, String s2) {
            int[][] dp = new int[s1.length()+1][s2.length()+1];
            for (int i=0;i<dp.length;i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0) dp[i][j] = j;
                    else if (j == 0) dp[i][j] = i;
                    else if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    }
                }
            }

            return dp[s1.length()][s2.length()] == 1;

        }
    }
}

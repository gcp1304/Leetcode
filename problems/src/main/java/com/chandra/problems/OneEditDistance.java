package com.chandra.problems;

/**
 * Check if edit distance between two strings is one
 *
 * An edit between two strings is one of the following changes.
 *
 *      Add a character
 *      Delete a character
 *      Change a character
 *
 *      Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit.
 *
 *      Expected time complexity is O(m+n) where m and n are lengths of two strings.
 */
public class OneEditDistance {
    public static class Solution_1 {

        /**
         * Time complexity: O(n)
         * Auxiliary Space: O(1)
         *
         */
        public boolean isEditDistanceOne(String s1, String s2) {
            // Find lengths of given strings
            int m = s1.length(), n = s2.length();

            // If difference between lengths is
            // more than 1, then strings can't
            // be at one distance
            if (Math.abs(m - n) > 1) return false;

            int i = 0, j = 0;
            int distanceCount = 0; // Count of edits

            while (i < m && j < n) {

                // If current characters don't match
                if (s1.charAt(i) != s2.charAt(j)) {
                    if (distanceCount == 1) return false;
                    distanceCount++;

                    // If length of one string is
                    // more, then only possible edit
                    // is to remove a character
                    if (m > n) i++;
                    else if (m < n) j++;
                    else { // If lengths of both strings are same
                        i++;
                        j++;
                    }
                } else { // If current characters match
                    i++;
                    j++;
                }
            }

            // If last character is extra
            // in any string
            if (i < m || j < n) distanceCount++;

            return distanceCount == 1;
        }
    }

    public static class Solution_2 {
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

    public static class Solution_3 {
        public boolean isEditDistanceOne(String s1, String s2) {
            // Find lengths of given strings
            int m = s1.length(), n = s2.length();

            // If difference between lengths is
            // more than 1, then strings can't
            // be at one distance
            if (Math.abs(m - n) > 1 || s1.equals(s2)) return false;

            for (int i = 0; i < Math.min(m, n); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (m == n) return s1.substring(i+1).equals(s2.substring(i+1)); // replace
                    else if (m > n) return s1.substring(i+1).equals(s2.substring(i)); // delete
                    else return s1.substring(i).equals(s2.substring(i+1)); // insert
                }
            }

            return Math.abs(m-n) == 1;
        }
    }

    public static void main(String[] args) {
        OneEditDistance.Solution_1 solution_1 = new Solution_1();
        OneEditDistance.Solution_2 solution_2 = new Solution_2();
        OneEditDistance.Solution_3 solution_3 = new Solution_3();

        System.out.println(solution_1.isEditDistanceOne("cat", "cast"));
        System.out.println(solution_2.isEditDistanceOne("cat", "cast"));
        System.out.println(solution_3.isEditDistanceOne("cat", "cast"));
    }
}

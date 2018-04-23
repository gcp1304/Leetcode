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

            if (Math.abs(m-n) > 1) return false;

            while (i < m && j < n) {
                // When both the chars are same
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    diffCount++; // doesn't matter what edit it is, increment the count
                    if (diffCount > 1) return false; // since there more than one edit

                    // If length of one string is greater than other, then possible action is to remove a char
                    if (m>n) i++;
                    else if (n>m) j++;
                    else { // if lengths of both strings is same
                        i++;
                        j++;
                    }

                }
            }

            // if last char is extra in any string
            if (i<m || j < n) {
                diffCount++;
            }

            return diffCount == 1;
        }
    }
}

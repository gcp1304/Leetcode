package com.chandra.problems;

/**
 * 44. Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "*"
 Output: true
 Explanation: '*' matches any sequence.
 Example 3:

 Input:
 s = "cb"
 p = "?a"
 Output: false
 Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 Example 4:

 Input:
 s = "adceb"
 p = "*a*b"
 Output: true
 Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 Example 5:

 Input:
 s = "acdcb"
 p = "a*c?b"
 Output: false
 */
public class Problem_44 {

   /** We define the state P[i][j] to be whether s[0..i) matches p[0..j). The state equations are as follows:
    P[i][j] = P[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '?'), if p[j - 1] != '*';
    P[i][j] = P[i][j - 1] || P[i - 1][j], if p[j - 1] == '*'.

 Equation 1). means that if p[j-1] is not *, f(i,j) is determined by if s[0:i-2] matches p[0:j-2] and if (s[i-1]==p[j-1] or p[j-1]=='?').
 Equation 2). means that if p[j-1] is *, f(i,j) is true if either f(i,j-1) is true: s[0:i-1] matches p[0:j-2] and * is not used here;
 or f(i-1,j) is true: s[0:i-2] matches p[0:j-1] and * is used to match s[i-1].
**/
    public static class Solution_1 {
        public boolean isMatch(String s, String p) {
            int sLen = s.length(), pLen = p.length();

            // if pattern is empty
            if (pLen == 0) return sLen == 0;

            boolean[][] lookup = new boolean[sLen+1][pLen+1];

            // empty pattern and empty string match
            lookup[0][0] = true;

            // if string is empty, '*' pattern can match
            for (int j = 1;j<=pLen;j++) {
                if (p.charAt(j-1) == '*') lookup[0][j] = lookup[0][j-1];
            }

            // fill in table with bottom-up approach
            for (int i = 1; i < lookup.length; i++) {
                for (int j = 1; j < lookup[0].length; j++) {

                    // Two cases if we see a '*'
                    // a) We ignore '*'' character and move
                    //    to next  character in the pattern,
                    //     i.e., '*' indicates an empty sequence.
                    // b) '*' character matches with ith
                    //     character in input
                    if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                        lookup[i][j] = lookup[i-1][j-1];
                    } else if (p.charAt(j-1) == '*') {
                        lookup[i][j] = lookup[i][j-1] || lookup[i-1][j];
                    }
                }
            }

            return lookup[sLen][pLen];
        }
    }
}

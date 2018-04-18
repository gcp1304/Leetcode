package com.chandra.problems;

/**
 * 10. Regular Expression Matching
 *
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */

public class Problem_10 {

    public static class Solution1 {
        public boolean isMatch(String s, String p) {
            // base case
            if (p.length() == 0)
                return s.length() == 0;

             /*
                When p has only one char
                1. If p length == 1, then return
                    a. If s length == 1 and
                    b. If s.chart(0) == p.charAt(0) or p.charAt(0) == '.'
            */
            if (p.length() == 1) return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

            // Now p has more than one char
            // If 2nd char in p is not '*'
            if (p.charAt(1) != '*') {
                if (s.length() == 0) return false;
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
            }

            // If 2nd char in p is '*'
            else { // p.charAt(1) == '*'
                while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                    // this has to be before s= s.substring(1), to deal with the case: s=abc  p = .*abc
                    // considering .* or a* in a*a as zero and using rest of the pattern as original pattern
                    if (isMatch(s, p.substring(2))) return true;

                    // this case is to deal with s = aaaaaaaabbbbbbb and p = a*b*
                    s = s.substring(1);
                }
                // if previous chars doesn't match or previous pattern char is not '.', then consider it as zero case hence
                // reduce pattern by 2 and consider the rest of the pattern as original and continue matching
                return isMatch(s, p.substring(2));
            }
        }
    }

    public static class Solution2 {
        /*
            1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
            2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
            3, If p.charAt(j) == '*':
                here are two sub conditions:
                    1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
                    2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length()+1][p.length()+1];
            dp[0][0] = true;

            for (int i=1;i<dp[0].length;i++) {
                if (p.charAt(i-1) == '*')
                    dp[0][i] = dp[0][i-2];
            }


            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    }

                    if (p.charAt(j-1) == '*') {
                        if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.') {
                            dp[i][j] = dp[i][j-2];
                        } else {
                            dp[i][j] = dp[i][j-2] || dp[i-1][j-1] || dp[i-1][j];
                        }
                    }
                }
            }

            return dp[s.length()][p.length()];
        }
    }
}

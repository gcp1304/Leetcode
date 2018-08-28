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

    // Solution1 Doesn't work for all the cases
    public static class Solution1 {
        public boolean isMatch(String t, String p) {
            if (p.isEmpty()) return t.isEmpty();
            boolean first_match = (!t.isEmpty() &&
                    (p.charAt(0) == t.charAt(0) || p.charAt(0) == '.'));

            if (p.length() >= 2 && p.charAt(1) == '*'){
                return (isMatch(t, p.substring(2)) || // when * is considered zero
                        (first_match && isMatch(t.substring(1), p))); // when previous character to start matches e.g p = a*b t=aaaaaaabbbbbb
            } else {
                return first_match && isMatch(t.substring(1), p.substring(1)); // when both t char and p char matches
            }
        }
    }

    public static class Solution2 {

        // text = aa
        // pat = a*

        /*
        dp[i][j]    = dp[i - 1][j - 1]	, p(j - 1) != '*' && s(i - 1) = p(j - 1)
                    = dp[i][j - 2]		, p(j - 1) == '*' && matches empty -> pat = a* considered as zero
                    = dp[i - 1][j] 	, p(j - 1) == '*' && s(i - 1) = p(j - 2), 'x' repeats >= 1 times -> pat = a* text = aa, current text char matches previous char of pat
         */

        public static boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }

            boolean[][] dp = new boolean[s.length()+1][p.length()+1];
            dp[0][0] = true; // both text and pattern are empty

            // when the text is empty and pattern is not empty
            for (int j=1;j<dp[0].length;j++) {
                if (p.charAt(j-1) == '*') {
                    dp[0][j] = dp[0][j-2]; // consider the *with previous char is empty so copy whatever it was previous
                }
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (p.charAt(j-1) != '*') {
                        dp[i][j] = dp[i-1][j-1] && isCharMatch(s.charAt(i-1), p.charAt(j-1));
                    } else { //p.charAt(j-1) == '*'
                        dp[i][j] = dp[i][j-2] // a* is considered zero or matches empty
                                || dp[i-1][j] && isCharMatch(s.charAt(i-1), p.charAt(j-2)); // previous char 'x' repeats >= 1 times
                    }
                }
            }

            return dp[s.length()][p.length()];
        }

        private static boolean isCharMatch(char s, char p) {
            return p == '.' || s == p;
        }
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";

        System.out.println(Solution_2.isMatch(s, p));
    }
}

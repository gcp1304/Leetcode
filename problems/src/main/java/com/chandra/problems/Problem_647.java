package com.chandra.problems;

/**
 * 647. Palindromic Substrings
 *
 * Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 Note:
 The input string length won't exceed 1000.

 */
public class Problem_647 {
    public static class Solution_1 {
        public int countSubstrings(String s) {
            int n = s.length();
            Boolean[][] dp = new Boolean[n][n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    res += isPalindrome(s, dp, i, j) ? 1 : 0;
                }
            }
            return res;
         }

        private boolean isPalindrome(String s, Boolean[][] dp, int i, int j) {
            if (i == j || i>j) return true;
            if (dp[i][j] != null) return dp[i][j];
            dp[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome(s, dp, i+1, j-1);
            return dp[i][j];
        }

    }

    public static void main(String[] args) {
        Problem_647.Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.countSubstrings("abc"));
    }
}

package com.chandra.problems;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class Problem_5 {
    // O(n^2)
    public static class Solution_1 {
        int start = 0;
        int maxLen = 0;
        public String longestPalindrome(String s) {
            if (s.isEmpty()) return s;
            for (int i=0;i<s.length();i++) {
                expand(i, i, s); // odd number of characters
                expand(i, i+1, s); // even number of characters
            }

            return s.substring(start, start + maxLen);

        }

        private void expand(int left, int right, String s) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (maxLen < right - left) {
                start = left+1;
                maxLen = right - left - 1;
            }
        }
    }
}

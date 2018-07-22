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
    public static class Solution {
        int start = 0, maxLen = 0;

        public String longestPalindrome(String s) {
            // if string is length is 1, then it's a palindrome return
            if (s.length() < 2) return s;

            // loop through the string character by character and keep expanding from the character to left and right
            // then keep track of maxLen whenever you encounter a palindrome string
            for (int i = 0; i < s.length() - 1; i++) {
                expandPalindrome(s, i, i);
                expandPalindrome(s, i, i + 1);
            }

            return s.substring(start, start + maxLen);
        }

        private void expandPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;

                if (maxLen < right - left - 1) {
                    maxLen = right - left - 1;
                    start = left + 1;
                }
            }
        }
    }
}

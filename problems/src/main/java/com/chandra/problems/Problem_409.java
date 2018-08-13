package com.chandra.problems;

/**
 * 409. Longest Palindrome
 * <p>
 * Given a string which consists of lowercase or uppercase letters, find the length of the
 * longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Problem_409 {
    public static class Solution_1 {

        // Add all counts for every char, whenever we encounter odd char decrement count by 1
        // at the end check if count < input string length, if yes add 1 if not return count

        public int longestPalindrome(String s) {
            if (s == null || s.length() == 0) return 0;

            int count = 0;
            int[] charCount = new int[128];
            for (int i = 0; i < s.length(); i++) {
                charCount[s.charAt(i)]++;
            }

            for (int i : charCount) {
                count += i;
                if (i % 2 == 1)
                    count--;
            }

            return count < s.length() ? count + 1 : count;
        }
    }
}

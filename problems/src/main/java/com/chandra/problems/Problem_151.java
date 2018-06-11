package com.chandra.problems;

/**
 * 151. Reverse Words in a String
 Given an input string, reverse the string word by word.
 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.

 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.

 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */

public class Problem_151 {
    public static class Solution_1 {

        // without split - O(n) runtime, O(n) space
        public String reverseWords(String s) {
            StringBuilder reversed = new StringBuilder();
            int j = s.length();
            for (int i=s.length() - 1; i>=0; i--) {
                if (s.charAt(i) == ' ') {
                    j = i;
                } else if (i == 0 || s.charAt(i-1) == ' ') {
                    if (reversed.length() != 0) {
                        reversed.append(' ');
                    }
                    reversed.append(s.substring(i, j));
                }
            }
            return reversed.toString();
        }
    }

    public static class Solution_2 {
        public String reverseWords(String s) {
            String[] tokens = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    sb.insert(0, token);
                    sb.insert(0, " ");
                }
            }
            return sb.toString().trim();
        }
    }
}

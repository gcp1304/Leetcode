package com.chandra.problems;

/**
 * 168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class Problem_168 {
    public static class Solution1 {
        public String convertToTitle(int n) {
            StringBuilder sb = new StringBuilder();
            while (n != 0) {
                sb.append((char) ((n - 1) % 26 + 'A'));
                n = (n - 1) / 26; // n-1 is for 0 based indexing
            }

            return sb.reverse().toString();
        }
    }
}

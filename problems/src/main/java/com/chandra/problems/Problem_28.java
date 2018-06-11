package com.chandra.problems;

/**
 * 28. Implement strStr()
 *
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 Clarification:

 What should we return when needle is an empty string? This is a great question to ask during an interview.

 For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class Problem_28 {
    public static class Solution1 {
        public int strStr(String haystack, String needle) {

            if (haystack == null || needle == null || haystack.length() < needle.length()) {
                return -1;
            }

            if (needle.length() == 0) return 0;

            for (int i = 0; ; i++) {
                for (int j = 0; ; j++) {
                    if (j == needle.length())
                        return i; // reached end of needle meaning all needle chars present in haystack
                    if (i + j == haystack.length())
                        return -1; // reached end of haystack meaning no match of needle chars
                    if (needle.charAt(j) != haystack.charAt(i + j))
                        break; // if chars don't match continue to next char in haystack
                }
            }
        }
    }

    public static class Solution2 {
        public int strStr(String haystack, String needle) {

            if (haystack == null || needle == null || haystack.length() < needle.length()) {
                return -1;
            }

            if (needle.length() == 0) return 0;

            for (int i=0;i<haystack.length() - needle.length(); i++) {
                if (haystack.substring(i, i+needle.length()).equals(needle)) return i;
            }

            return -1;
        }
    }
}

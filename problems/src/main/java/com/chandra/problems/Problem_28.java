package com.chandra.problems;

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

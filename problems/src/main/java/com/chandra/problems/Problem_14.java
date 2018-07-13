package com.chandra.problems;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class Problem_14 {

    public static class Solution {

        // Horizontal Scanning
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";

            String prefix = strs[0]; // take first str as prefix
            for (int i = 1; i < strs.length; i++) { // loop through rest of the strings
                while (strs[i].indexOf(prefix) != 0) { // check if prefix is present in the current string, if present then index will be zero if not reduce prefix by character
                    prefix = prefix.substring(0, prefix.length()-1); // if prefix is not present then keep reducing prefix by character from last
                    if (prefix.isEmpty()) return ""; // at any time if we exhaust all characters in prefix return ""
                }
            }
            return prefix; // if we exit the forloop then we have LCP
        }
    }

    public static class Solution_1 {
        public String longestCommonPrefix(String[] strs) {

            String prefix = "";
            if (strs == null || strs.length == 0) return prefix;
            prefix = strs[0];
            // pick the smallest string as prefix from the input
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < prefix.length()) {
                    prefix = strs[i];
                }
            }

            for (String str : strs) {
                // check if prefix is part of all the strings. At any point if prefix is not a substring, then
                // remove last char from prefix and continue checking.

                // If prefix is matched with string then even after removing last char from prefix it would still match
                while (!prefix.equals(str.substring(0, prefix.length())) && !prefix.equals("")) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }

            return prefix;
        }
    }
}

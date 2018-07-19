package com.chandra.problems;

import java.util.HashMap;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 Example 1:
 Input: "eceba"
 Output: 3
 Explanation: t is "ece" which its length is 3.
 Example 2:
 Input: "ccaabbb"
 Output: 5
 Explanation: t is "aabbb" which its length is 5.
 */
public class Problem_159 {

    // abbccd
    public static class Solution_1 {
        public static int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s == null || s.length() == 0) return 0;

            HashMap<Character, Integer> map = new HashMap<>();

            int start = 0, end = 0, maxLen=0;

            while (end < s.length()) {
                char c = s.charAt(end++);
                map.put(c, map.getOrDefault(c, 0) + 1);

                while (map.size() > 2) {
                    char c1 = s.charAt(start++);
                    map.put(c1, map.get(c1) - 1);
                    if (map.get(c1) == 0) map.remove(c1);
                }
                maxLen = Math.max(maxLen, end - start);
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution_1.lengthOfLongestSubstringTwoDistinct("eceba"));
    }


}

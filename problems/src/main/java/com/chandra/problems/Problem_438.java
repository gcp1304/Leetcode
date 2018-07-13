package com.chandra.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class Problem_438 {
    public static class Solution_1 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
            }

            int count = map.size();
            int left = 0, right = 0;
            while (right < s.length()) {

                char c = s.charAt(right++);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) count--;
                }

                while (count == 0) {
                    if (right - left == p.length()) res.add(left);
                    char c1 = s.charAt(left++);
                    if (map.containsKey(c1)) {
                        map.put(c1, map.get(c1) + 1);
                        if (map.get(c1) > 0) count++;
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        String s= "cbaebabacd", p= "abc";

        System.out.println(new Problem_438.Solution_1().findAnagrams(s, p).toString());
    }
}

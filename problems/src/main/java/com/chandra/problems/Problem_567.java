package com.chandra.problems;

import java.util.HashMap;

/**
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False
 Note:
 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].
 */
public class Problem_567 {
    public static class Solution_1 {

        // Sliding Window
        public static boolean checkInclusion(String s1, String s2) {

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            }

            int begin=0, end=0, counter = map.size();

            while (end < s2.length()) {

                char c = s2.charAt(end++);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) counter--;
                }

                while (counter == 0) {
                    if (end - begin == s1.length()) return true;
                    char c1 = s2.charAt(begin);
                    if (map.containsKey(c1)) {
                        map.put(c1, map.get(c1) + 1);
                        if (map.get(c1) > 0) counter++;
                    }
                    begin++;
                }

            }

            return false;

        }
    }

    public static void main(String[] args) {
        String s1 = "trinitrophenylmethylnitramine", s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
        System.out.println(Problem_567.Solution_1.checkInclusion(s1, s2));
    }
}

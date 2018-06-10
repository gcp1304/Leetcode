package com.chandra.problems;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note:

 All inputs will be in lowercase.
 The order of your output does not matter.
 */

public class Problem_49 {

    // Hash + Sort -> O(mnlogn) time, O(m) space, m is the num of strs, n is the length of strs
    public static class Solution_1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String s = String.valueOf(chars);
                if (!map.containsKey(s)) {
                    map.put(s, new ArrayList<>());
                }
                map.get(s).add(str);
            }

            return new ArrayList<>(map.values());
        }
    }

    // Hash + Counting Sort -> O(mn) time, O(m) space, m is the num of strs, n is the length of strs
    public static class Solution_2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                int[] count = new int[26]; //cuz inputs are lowercase letters, we only need 26
                for (int i = 0; i < str.length(); i++) {
                    count[str.charAt(i) - 'a']++;
                }

                String anagram = ""; //build a string key, eg."aabcccdd" -> 2a1b3c2d
                for (int i = 0; i < count.length; i++) {
                    if (count[i] != 0)
                        anagram += String.valueOf(count[i]) + String.valueOf((char)('a' + i));
                }

                if (!map.containsKey(anagram)) map.put(anagram, new ArrayList<>());
                map.get(anagram).add(str);
            }

            return new ArrayList<>(map.values());
        }
    }
}

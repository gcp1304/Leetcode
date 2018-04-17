package com.chandra.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem_3 {

    /**
     * Time - O(n)
     * Space - O(n)
     */

    public static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int len = 0;
            if (s.isEmpty()) return len;

            HashSet<Character> set = new HashSet<>();

            for (int start = 0, end = start; end < s.length(); end++) {
                // expanding the sliding window
                char c = s.charAt(end);
                if (!set.contains(c)) {
                    set.add(c);
                } else {
                    len = Math.max(len, set.size());
                    while (set.contains(c)) {
                        // shrinking the sliding window
                        set.remove(s.charAt(start++));
                    }
                    set.add(c);
                }
            }
            return len;
        }
    }

    /**
     * Time - O(n)
     * Space - O(n)
     */

    public static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int len = 0;
            if (s.isEmpty()) return len;

            HashMap<Character, Integer> map = new HashMap<>();
            for (int start=0, end = start; end < s.length();) {
                char c = s.charAt(end);
                if (!map.containsKey(c) || (map.containsKey(c) && map.get(c) == 0)) {
                    map.put(c, 1);
                    len = Math.max(len, end - start+1);
                    end++;
                } else {
                    map.put(s.charAt(start++), map.get(c) - 1);
                }
            }
            return len;
        }
    }

    /**
     * Time - O(n)
     * Space - O(n)
     */

    public static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int len = 0;
            if (s.isEmpty()) return len;

            Set<Character> set = new HashSet<>();

            for (int start=0, end=0; end < s.length();) {
                char c = s.charAt(end);
                if (!set.contains(c)) {
                    set.add(c);
                    end++;
                    len = Math.max(len, end - start);
                } else {
                    set.remove(s.charAt(start++));
                }
            }
            return len;
        }
    }
}

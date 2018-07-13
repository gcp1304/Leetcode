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

        /**
         * Algorithm

         The naive approach is very straightforward. But it is too slow. So how can we optimize it?

         In the naive approaches, we repeatedly check a substring to see if it has duplicate character. But it is unnecessary. If a substring s_{ij}s
         ​ij
         ​​  from index ii to j - 1j−1 is already checked to have no duplicate characters. We only need to check if s[j]s[j] is already in the substring s_{ij}s
         ​ij
         ​​ .

         To check if a character is already in the substring, we can scan the substring, which leads to an O(n^2)O(n
         ​2
         ​​ ) algorithm. But we can do better.

         By using HashSet as a sliding window, checking if a character in the current can be done in O(1)O(1).

         A sliding window is an abstract concept commonly used in array/string problems. A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i, j)[i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the certain direction. For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).

         Back to our problem. We use HashSet to store the characters in current window [i, j)[i,j) (j = ij=i initially). Then we slide the index jj to the right. If it is not in the HashSet, we slide jj further. Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of substrings without duplicate characters start with index ii. If we do this for all ii, we get our answer.
         */
        public int lengthOfLongestSubstring(String s) {
            int len = 0;
            if (s.isEmpty()) return len;

            int n = s.length();
            int start = 0, end = 0;
            HashSet<Character> set = new HashSet<>();
            while (start < n && end < n) {
                if (!set.contains(s.charAt(end))) {
                    set.add(s.charAt(end++));
                    len = Math.max(len, end - start);
                } else {
                    set.remove(s.charAt(start++));
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
            for (int start=0, end = 0; end < s.length(); end++) {
                if (map.containsKey(s.charAt(end))) {
                    // whenever a repeated character is found we move start pointer in sliding window to the next index
                    start = Math.max(map.get(s.charAt(end)), start);
                }

                len = Math.max(len, end - start);
                map.put(s.charAt(end), end);

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

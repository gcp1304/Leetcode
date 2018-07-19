package com.chandra.problems;

import java.util.*;

/**
 * 139. Word Break
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class Problem_139 {

    /**
     * Algorithm
     * The given problem can be solved by using Dynamic Programming as described below:
     1. Create a temporary boolean array validWords[] defined as:
     validWords[i]
     = true, if input substring from 0 to i forms valid words string
     = false, otherwise
     2. For i = 0 to input.length,
     a. If input substring from 0...i is present in the dictionary, then set validWords[i] = true
     b. If validWords[i] == true, from j = i+1 to n-1, check if substring from i+1 to j, for all values of j (= i+1 to n-1), is present in the dictionary and set validWords[j] to true if found in the dictionary.
     3. When we reach the end of the string, if validWords[n-1] is true, then return true else return false.
     */
    // Time O(N^2), space - O(N)
    public static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] breakable = new boolean[s.length()];

            for (int i = 0; i < s.length(); i++) {
                if (wordDict.contains(s.substring(0, i+1))) breakable[i] = true;

                if (i == s.length()-1 && breakable[i]) return true;

                if (breakable[i]) {
                    for (int j = i+1; j < s.length(); j++) {
                        if (wordDict.contains(s.substring(i+1, j+1))) breakable[j] = true;
                        if (j == s.length()-1 && breakable[i]) return true;
                    }
                }
            }

            return false;
        }
    }

    /*
     The idea here to keep checkpoint whenever we encounter a word which is present in list in conjunction with
     previous encountered word if any. Once we reach the end of the string length we return the result.
     */
    public static class Solution1 {
        // Time Complexity - O(n^3) and Space - O(n)
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] breakable = new boolean[s.length() + 1];

            breakable[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (wordDict.contains(s.substring(j, i)) && breakable[j]) breakable[i] = true;
                }
            }
            return breakable[s.length()];

        }
    }

    public static class Solution2 {
        // Time Complexity - O(n^2) and Space - O(n)
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] breakable = new boolean[s.length() + 1];

            breakable[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                // Instead of parsing from head to tail, do it from tail to head.
                // whenever we encounter a valid word break and move on to next which saves time.
                for (int j = i - 1; j >= 0; j--) {
                    if (wordDict.contains(s.substring(j, i)) && breakable[j]) {
                        breakable[i] = true;
                        break;
                    }
                }
            }
            return breakable[s.length()];

        }
    }

    // From https://leetcode.com/problems/word-break/discuss/43797/A-solution-using-BFS
    /*
    People have posted elegant solutions using DP. The solution I post below using BFS is no better than those.
    Just to share some new thoughts.

    We can use a graph to represent the possible solutions. The vertices of the graph are simply the positions of
    the first characters of the words and each edge actually represents a word. For example, the input string
    is “nightmare”, there are two ways to break it, “night mare” and “nightmare”. The graph would be

    0–>5–>9

    |__ __ _^

    The question is simply to check if there is a path from 0 to 9. The most efficient way is
    traversing the graph using BFS with the help of a queue and a hash set. The hash set is used to keep track of
    the visited nodes to avoid repeating the same work.

    For this problem, the time complexity is O(n^2) and space complexity is O(n), the same with DP.
    This idea can be used to solve the problem word break II. We can simple construct the graph using BFS,
    save it into a map and then find all the paths using DFS.
     */
    public static class Solution3 {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict.contains(s)) return true;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(0);
            // use a set to record checked index to avoid repeated work.
            // This is the key to reduce the running time to O(N^2).
            Set<Integer> visited = new HashSet<Integer>();
            visited.add(0);
            while (!queue.isEmpty()) {
                int curIdx = queue.poll();
                for (int i = curIdx + 1; i <= s.length(); i++) {
                    if (visited.contains(i)) continue;
                    if (wordDict.contains(s.substring(curIdx, i))) {
                        if (i == s.length()) return true;
                        queue.offer(i);
                        visited.add(i);
                    }
                }
            }
            return false;
        }
    }
}

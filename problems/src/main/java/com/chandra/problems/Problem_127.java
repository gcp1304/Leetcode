package com.chandra.problems;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * 127. Word Ladder
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class Problem_127 {
    public static class Solution1 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> words = new HashSet<>(wordList);
            words.add(beginWord);

            Queue<String> queue = new ArrayDeque<>();
            queue.offer(beginWord);
            int level = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                // BFS -> Going level by level
                while (size-- > 0) {
                    String word = queue.poll();

                    char[] letters = word.toCharArray();
                    for (int i = 0; i < letters.length; i++) {
                        // replacing each char with every alphabet and checking existence of new word in set
                        for (int j=0;j<26;j++) {
                            if ((char)('a'+j) != word.charAt(i)) {
                                letters[i] = (char)('a'+j);
                                String newWord = new String(letters);
                                // when word exists in set, remove it and add to queue for BFS on the new word
                                if (words.contains(newWord)) {
                                    if (newWord.equals(endWord)) return level+1;
                                    words.remove(newWord);
                                    queue.offer(newWord);
                                }
                                letters[i] = word.charAt(i);
                            }
                        }
                    }
                }
                level++;
            }
            return 0;
        }
    }
}

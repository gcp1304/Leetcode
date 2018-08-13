package com.chandra.problems;

import java.util.*;

/**
 * 212. Word Search II
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 Example:

 Input:
 words = ["oath","pea","eat","rain"] and board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 Output: ["eat","oath"]
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class Problem_212 {
    public static class Solution_1 {

        /**
         * Backtracking + Trie
         Intuitively, start from every cell and try to build a word in the dictionary. Backtracking (dfs) is the powerful
         way to exhaust every possible ways. Apparently, we need to do pruning when current character is not in any word.

         How do we instantly know the current character is invalid? HashMap?
         How do we instantly know what's the next valid character? LinkedList?
         But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
         Combing them, Trie is the natural choice. Notice that:

         TrieNode is all we need. search and startsWith are useless.
         No need to store character at TrieNode. c.next[i] != null is enough.
         Never use c1 + c2 + c3. Use StringBuilder.
         No need to use O(n^2) extra space visited[m][n].
         No need to use StringBuilder. Storing word itself at leaf node is enough.
         No need to use HashSet to de-duplicate. Use "one time search" trie.
         */

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
        }

        private TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String word : words) {
                TrieNode p = root;
                for (char c : word.toCharArray()) {
                    int i = c - 'a';
                    if (p.next[i] == null) p.next[i] = new TrieNode();
                    p = p.next[i];
                }
                p.word = word;
            }

            return root;
        }

        public List<String> findWords(char[][] board, String[] words) {
            List<String> result = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, root, result);
                }
            }

            return result;
        }

        private void dfs(char[][] board, int i, int j, TrieNode p, List<String> result) {
            char c = board[i][j];

            if (c == '#' || p.next[c - 'a'] == null) return;
            p = p.next[c - 'a'];
            if (p.word != null) { // when found word
                result.add(p.word);
                p.word = null; // this is to avoid duplication
            }

            board[i][j] = '#'; // set the visited character to #
            if (i>0) dfs(board, i-1, j, p, result);
            if (i < board.length-1) dfs(board, i+1, j, p, result);
            if (j>0) dfs(board, i, j-1, p, result);
            if (j < board[0].length-1) dfs(board, i, j+1, p, result);
            board[i][j] = c; // reset # to character since same character can be used in different word
        }
    }
}

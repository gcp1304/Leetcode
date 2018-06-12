package com.chandra.problems;

/**
 * 211. Add and Search Word - Data structure design
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A
 * . means it can represent any one letter.
 *
 * For example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class Problem_211 {

    public static class Solution1 {
        private class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
        }

        class WordDictionary {

            private TrieNode root = null;

            /**
             * Initialize your data structure here.
             */
            public WordDictionary() {
                root = new TrieNode();
            }

            /**
             * Adds a word into the data structure.
             */
            public void addWord(String word) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                }
                node.isWord = true;
            }

            /**
             * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
             */
            public boolean search(String word) {
                return dfs(word.toCharArray(), 0, root);
            }

            private boolean dfs(char[] chars, int k, TrieNode node) {
                if (k == chars.length) return node.isWord;


                if (chars[k] == '.') {
                    for (int i = 0; i < node.children.length; i++) {
                        if (node.children[i] != null && dfs(chars, k + 1, node.children[i])) return true;
                    }
                } else {
                    return node.children[chars[k] - 'a'] != null && dfs(chars, k + 1, node.children[chars[k] - 'a']);
                }
                return false;
            }
        }
    }
}

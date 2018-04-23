package com.chandra.problems;

public class Problem_208 {
    public static class Solution1 {
        private class TrieNode {
            public boolean isLeaf = false;
            public TrieNode[] children = new TrieNode[26];
        }

        public class Trie {

            private TrieNode root;

            /**
             * Initialize your data structure here.
             */
            public Trie() {
                root = new TrieNode();
            }

            /**
             * Inserts a word into the trie.
             */
            public void insert(String word) {
                TrieNode node = root;
                word = word.toLowerCase();

                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (node.children[ch - 'a'] == null) {
                        node.children[ch - 'a'] = new TrieNode();
                    }
                    node = node.children[ch - 'a'];
                }
                node.isLeaf = true;
            }

            /**
             * Returns if the word is in the trie.
             */
            public boolean search(String word) {
                TrieNode node = searchHelper(word);
                return node != null && node.isLeaf;
            }

            /**
             * Returns if there is any word in the trie that starts with the given prefix.
             */
            public boolean startsWith(String prefix) {
                return searchHelper(prefix) != null;
            }

            private TrieNode searchHelper(String key) {
                key = key.toLowerCase();
                TrieNode node = root;
                for (int i = 0; i < key.length() && node != null; i++) {
                    char ch = key.charAt(i);
                    node = node.children[ch - 'a'];
                }
                return node;
            }
        }
    }
}

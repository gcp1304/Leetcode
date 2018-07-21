package com.chandra.problems;

/**
 *
 * 318. Maximum Product of Word Lengths
 *
 *
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:

 Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 Output: 16
 Explanation: The two words can be "abcw", "xtfn".
 Example 2:

 Input: ["a","ab","abc","d","cd","bcd","abcd"]
 Output: 4
 Explanation: The two words can be "ab", "cd".
 Example 3:

 Input: ["a","aa","aaa","aaaa"]
 Output: 0
 Explanation: No such pair of words.
 */
public class Problem_318 {
    public static class Solution_1 {
        public int maxProduct(String[] words) {

            int maxProduct = 0;
            for (int i=0;i<words.length-1;i++) {
                for (int j = i+1; j < words.length; j++) {
                    if (!shareLetter(words[i], words[j])) {
                        maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                    }
                }
            }

            return maxProduct;

        }

        public boolean shareLetter(String s1, String s2) {
            boolean[] letters = new boolean[26];
            for (char c : s1.toCharArray()) {
                letters[c-'a'] = true;
            }

            for (char c : s2.toCharArray()) {
                if (letters[c-'a']) return true;
            }
            return false;
        }
    }

    public static class Solution_2 {// Faster than solution 1

        public int maxProduct(String[] words) {
            //convert each string into bitset
            int[] nums = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                char[] wordChars = words[i].toCharArray();
                for (char c : wordChars) {
                    nums[i] |= (1 << c-'a'); //ORing every char will provide all bitset value
                }
            }
            int maxProduct = 0;
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i+1; j < words.length; j++) {
                    if ((nums[i] & nums[j]) == 0) { // if both bitset values are same then masking them would result in 0 meaning both words doesn't have anything in common
                        maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                    }
                }
            }

            return maxProduct;
        }
    }
}

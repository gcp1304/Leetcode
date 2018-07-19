package com.chandra.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 524. Longest Word in Dictionary through Deleting
 *
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by
 * deleting some characters of the given string. If there are more than one possible results,
 * return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 Example 1:
 Input:
 s = "abpcplea", d = ["ale","apple","monkey","plea"]

 Output:
 "apple"
 Example 2:
 Input:
 s = "abpcplea", d = ["a","b","c"]

 Output:
 "a"
 Note:
 All the strings in the input will only contain lower-case letters.
 The size of the dictionary won't exceed 1,000.
 The length of all the strings in the input won't exceed 1,000.
 */
public class Problem_524 {
    /**
     * Due to the fact that given dictionary doesn't go beyond 1000, we can sort them by length from high to low.
     * If two items have same length then we sort them lexicographically.
     *
     * Check if dictionary word can be formed from string by checking the characters present in string and word.
     * If we process all the chars in word, then that's the word which can be formed from input string
     */

    public static class Solution_1 {
        public static String findLongestWord(String s, List<String> d) {
            Collections.sort(d, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length();
                }
            });

            for (String word : d) {
                if (canFormWord(s, word)) return word;
            }

            return "";
        }

        private static boolean canFormWord(String str, String word) {
            char[] strChars = str.toCharArray();
            char[] wordChars = word.toCharArray();

            int si =0, wi = 0;

            while (si < strChars.length && wi < word.length()) {
                if (strChars[si] == wordChars[wi]) {
                    si++;
                    wi++;
                } else {
                    si++;
                }
            }
            return wi == wordChars.length;
        }
    }


    public static class Solution_2 {
        // faster compared to sol_1
        public static String findLongestWord(String s, List<String> d) {
            String longestString = "";
            for (String word : d) {
                if (isBetter(word, longestString) && isSubsequence(word, s)){
                    longestString = word;
                }
            }

            return longestString;
            
        }
        
        // This function checks if the new word is longer than the current longest word
        // or if it's of same length then it checks the lexicographical order, then return true if it's better
        public static boolean isBetter(String word, String longestWord) {
            return word.length() > longestWord.length() || (word.length() == longestWord.length() && word.compareTo(longestWord) < 0);
        }
        
        public static boolean isSubsequence(String word, String s) {
            if (word.length() > s.length()) return false;
            
            int start = -1;
            for (int i = 0; i < word.length(); i++) {
                // idenfiy the index of word char in input string after the given position,
                // the start+1 is IMPORTANT because we want to check for existence of current word char after that position
                // to make sure all word chars are present in input string
                start = s.indexOf(word.charAt(i), start + 1);
                if (start < 0) return false; // if we don't find word char then we receive -1 hence our subsequence is not present
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dict = new ArrayList<>();
        dict.add("ale");
        dict.add("apple");
        dict.add("monkey");
        dict.add("plea");

        System.out.println(Solution_2.findLongestWord(s, dict));
    }
}

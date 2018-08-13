package com.chandra.problems;

import java.util.*;

/**
 * 336. Palindrome Pairs
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:

 Input: ["abcd","dcba","lls","s","sssll"]
 Output: [[0,1],[1,0],[3,2],[2,4]]
 Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 Example 2:

 Input: ["bat","tab","cat"]
 Output: [[0,1],[1,0]]
 Explanation: The palindromes are ["battab","tabbat"]
 */
public class Problem_336 {
    public static class Solution_1 {
        /*
        There are several cases to be considered that isPalindrome(s1 + s2):

        Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.

        Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.

        Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.

        Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.

        To make the search faster, build a HashMap to store the String-idx pairs.
         */

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();

            if (words == null || words.length == 0) return res;

            HashMap<String, Integer> map = new HashMap<>();
            for (int i=0;i<words.length;i++) {
                map.put(words[i], i);
            }

            // Special case: "" can be combined with any palindrome word
            if (map.containsKey("")) {
                int emptyIndex = map.get("");
                for (int i=0;i<words.length;i++) {
                    if (isPalindrome(words[i])) {
                        if (emptyIndex == i) continue;
                        res.add(Arrays.asList(emptyIndex, i));
                        res.add(Arrays.asList(i, emptyIndex));
                    }
                }
            }

            //find all string and reverse string pairs
            for (int i=0;i<words.length;i++) {
                String reverse = reverseWord(words[i]);
                if (map.containsKey(reverse)) {
                    int found = map.get(reverse);
                    if (found == i) continue;
                    res.add(Arrays.asList(i, found));
                }
            }

            //find the pair s1, s2 that
            //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
            //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
            for (int i=0;i<words.length;i++) {
                String word = words[i];
                for (int cut=1;cut<word.length();cut++) {

                    //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
                    if (isPalindrome(word.substring(0, cut))) {
                        String partialReverse = reverseWord(word.substring(cut));
                        if (map.containsKey(partialReverse)) {
                            int found = map.get(partialReverse);
                            if (found == i) continue;
                            res.add(Arrays.asList(found, i));
                        }
                    }

                    if (isPalindrome(word.substring(cut))) {
                        String partialReverse = reverseWord(word.substring(0, cut));
                        if (map.containsKey(partialReverse)) {
                            int found = map.get(partialReverse);
                            if (found == i) continue;
                            res.add(Arrays.asList(i, found));
                        }
                    }

                }
            }

            return res;

        }

        private String reverseWord(String word) {
            StringBuilder sb = new StringBuilder(word);
            return sb.reverse().toString();
        }

        private boolean isPalindrome(String word) {
            int left = 0;
            int right = word.length()-1;
            while (left <= right) {
                if (word.charAt(left) != word.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }

        public static void main(String[] args) {
            Solution_1 solution_1 = new Solution_1();
            String[] words = {"abcd","dcba","lls","s","sssll"};
            List<List<Integer>> res = solution_1.palindromePairs(words);
            for (List<Integer> r : res) {
                System.out.println(r.toString());
            }
        }
    }

}

package com.chandra.problems;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class Problem_131 {
    public static class Solution_1 {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            backtracking(s, 0, new ArrayList<String>(), res);
            return res;
        }

        private void backtracking(@NotNull String s, int start, ArrayList<String> currentPalindrome, List<List<String>> res) {
            if (start == s.length()) {
                res.add(new ArrayList<>(currentPalindrome));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    currentPalindrome.add(s.substring(start, i+1));
                    backtracking(s, i+1, currentPalindrome, res);
                    currentPalindrome.remove(currentPalindrome.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int i, int j) {
            while (i < j)
                if (s.charAt(i++) != s.charAt(j--)) return false;
            return true;
        }

    }

    public static void main(String[] args) {
        Problem_131.Solution_1 solution_1 = new Solution_1();
        List<List<String>> res = solution_1.partition("aab");

    }
}

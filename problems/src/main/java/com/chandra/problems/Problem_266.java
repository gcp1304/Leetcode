package com.chandra.problems;

import java.util.HashSet;

/**
 * 266. Palindrome Permutation
 *
 * Given a string, determine if a permutation of the string could form a palindrome.

 Example 1:

 Input: "code"
 Output: false
 Example 2:

 Input: "aab"
 Output: true
 Example 3:

 Input: "carerac"
 Output: true
 */

public class Problem_266 {
    /*
    Analysis
    If a string with an even length is a palindrome, every character in the string must
    always occur an even number of times. If the string with an odd length is a palindrome,
    every character except one of the characters must always occur an even number of times.
    Thus, in case of a palindrome, the number of characters with odd number of occurences can't
    exceed 1(1 in case of odd length and 0 in case of even length).

    when we find a character in the string ss that isn't present in the setset(indicating an odd number of
    occurences currently for this character), we put its corresponding entry in the setset.
    If we find a character that is already present in the setset(indicating an even number of
    occurences currently for this character), we remove its corresponding entry from the setset.

At the end, the size of setset indicates the number of elements with odd number of occurences in ss.
If it is lesser than 2, a palindromic permutation of the string ss is possible, otherwise not.


Time - O(n) single pass
     */
    public static class Solution_1 {
        public boolean canPermutePalindrome(String s) {
            HashSet<Character> set = new HashSet<>();

            for (int i=0;i<s.length();i++) {
                if (!set.add(s.charAt(i))) {
                    set.remove(s.charAt(i));
                }
            }

            return set.size() <= 1;
        }
    }
}

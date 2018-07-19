package com.chandra.problems;

import java.util.HashSet;

/**
 * 345. Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class Problem_345 {
    public static class Solution_1 {
        public static String reverseVowels(String s) {
            char[] chars = s.toCharArray();

            HashSet<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');

            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');


            int start = 0, end = chars.length-1;
            while (start <= end) {
                while (start < end && !isVowel(chars[start])) start++;
                while (start < end && !isVowel(chars[end])) end--;
                if (start <= end) {
                    swap(chars, start, end);
                    start++;
                    end--;
                }
            }

            return String.valueOf(chars);
        }

        private static boolean isVowel(char ch) {
            return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
        }

        private static void swap(char[] chars, int left, int right) {
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
        }

        public static void main(String[] args) {
            System.out.println(Solution_1.reverseVowels("hello"));
        }
    }
}

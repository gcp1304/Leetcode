package com.chandra.problems;


/**
 *
 * 273. Integer to English Words
 *
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Hint:
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
 * There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
 */

public class Problem_273 {
    public static class Solution1 {
        public String numberToWords(int num) {
            final String[] LESS_THAN_20 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
            final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

            final int BILLION = 1000000000;
            final int MILLION = 1000000;
            final int THOUSAND = 1000;
            final int HUNDERED = 100;

            if (num == 0) return LESS_THAN_20[num];

            StringBuilder words = new StringBuilder();

            if (num >= BILLION) {
                words.append(numberToWords(num / BILLION)).append(" Billion ");
                num %= BILLION;
            }

            if (num >= MILLION) {
                words.append(numberToWords(num / MILLION)).append(" Million ");
                num %= MILLION;
            }

            if (num >= THOUSAND) {
                words.append(numberToWords(num / THOUSAND)).append(" Thousand ");
                num %= THOUSAND;
            }

            if (num >= HUNDERED) {
                words.append(numberToWords(num / HUNDERED)).append(" Hundred ");
                num %= HUNDERED;
            }

            if (num >= 20) {
                words.append(TENS[num / 10]).append(" ");
                num %= 10;
            }

            if (num > 0) {
                words.append(LESS_THAN_20[num]);
            }

            return words.toString().trim().replace("  ", " ");

        }
    }
}

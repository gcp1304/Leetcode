package com.chandra.problems;

/**
 * 9. Palindrome Number
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class Problem_9 {
    public static class Solution_1 {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;

            int rev = 0, xx = x;

            // reversing integer
            while (x != 0) {
                rev = rev * 10 + x % 10;
                x /= 10;
            }

            return rev == xx;
        }
    }

    public static class Solution_2 {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;

            int div = 1;
            // Below while loop is for checking the length of input-1
            while (x / div >= 10) {
                div *= 10; // this div will be used to compute first digit
            }

            while (x != 0) {
                int l = x / div;
                int r = x % 10;
                if (l != r) return false;
                x = (x % div) / 10; // modulus is to remove first digit and division on modulus result is to remove last digit
                div /= 100; // since two digits were removed if they match hence div is reduced by dividing 100
            }
            return true;
        }
    }

    public static class Solution_3 {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;

            String str = String.valueOf(x);
            int i=0, j = str.length()-1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
    }
}

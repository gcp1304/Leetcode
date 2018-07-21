package com.chandra.problems;


/**
 * 415. Add Strings
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class Problem_415 {
    public static class Solution_1 {
        public static String addStrings(String num1, String num2) {
            char[] num1Chars = num1.toCharArray();
            char[] num2Chars = num2.toCharArray();

            int i = num1Chars.length-1, j = num2Chars.length-1;

            int carry = 0;
            StringBuilder sb = new StringBuilder();

            while (i >=0 || j >= 0) {
                int c1 = (i >= 0) ? num1Chars[i] - '0' : 0;
                int c2 = (j >= 0) ? num2Chars[j] - '0' : 0;

                int sum = c1 + c2 + carry;
                sb.append(sum % 10);
                carry = sum/10;

                i--;
                j--;
            }
            if (carry == 1) sb.append(carry);
            return sb.toString();
        }

        public static void main(String[] args) {
            System.out.println(Solution_1.addStrings("935", "146"));
        }
    }
}

package com.chandra.problems;


/**
 * 66. Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.

 Example 1:

 Input: [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:

 Input: [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
 */
public class Problem_66 {
    public static class Solution_1 {
        public int[] plusOne(int[] digits) {

            for (int i=digits.length-1;i>=0;i--) {
                // if a digit is less then 9 then increment it and return the array which is a new number
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }

                // if it's 9 then replace it with zero and continue since we are going to increment if the next digit is less than 9
                digits[i] = 0;
            }

            // the only time we will be here is if all the digits are 9
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            return newDigits;
        }
    }
}

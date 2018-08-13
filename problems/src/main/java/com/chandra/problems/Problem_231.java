package com.chandra.problems;

/**
 * 231. Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.

 Example 1:

 Input: 1
 Output: true
 Explanation: 20 = 1
 Example 2:

 Input: 16
 Output: true
 Explanation: 24 = 16
 Example 3:

 Input: 218
 Output: false

 */
public class Problem_231 {
    public static class Solution_1 {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && ((n - 1) & n) == 0;
        }
    }
    
    public static class Solution_2 {
        public boolean isPowerOfTwo(int n) {
            int i=0;
            while (true) {
                if (Math.pow(2, i) == n) return true;
                if (Math.pow(2, i) > n) break;
            }

            return false;
        }
    }
}

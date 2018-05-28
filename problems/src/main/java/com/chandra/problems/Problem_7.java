package com.chandra.problems;

/**
 * 7. Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 */
public class Problem_7 {

    public static class Solution_1 {
        public int reverse(int x) {
            int res = 0;
            if (Math.abs(res) > Integer.MAX_VALUE/10) return 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x /= 10;
            }
            return res;
        }
    }
}

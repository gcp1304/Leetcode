package com.chandra.problems;

/**
 *
 * 29. Divide Two Integers
 *
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero.

 Example 1:

 Input: dividend = 10, divisor = 3
 Output: 3
 Example 2:

 Input: dividend = 7, divisor = -3
 Output: -2
 Note:

 Both dividend and divisor will be 32-bit signed integers.
 The divisor will never be 0.
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class Problem_29 {
    public static class Solution_1 {
        /** (without multiply or division): Bit Manipulation
         * Suppose we want to divide 15 by 3, so 15 is dividend and 3 is divisor. Well, division simply requires us to find how many times we can subtract the divisor from the the dividend without making the dividend negative.
         We subtract 3 from 15 and we get 12, which is positive. Then, we shift 3 to the left by 1 bit and we get 6.
         Subtracting 6 from 15 still gives a positive result. Well, we shift again and get 12.
         We subtract 12 from 15 and it is still positive. We shift again, obtaining 24 and we know we can at most subtract 12.
         Well, since 12 is obtained by shifting 3 to left twice, we know it is 4 times of 3. How do we obtain this 4?
         Well, we start from 1 and shift it to left twice at the same time. We add 4 to an answer (initialized to be 0).
         In fact, the above process is like 15 = 3 * 4 + 3. We now get part of the quotient (4), with a remainder 3.
         Then we repeat the above process again. We subtract divisor = 3 from the remaining dividend = 3 and obtain 0.
         We know we are done. No shift happens, so we simply add 1 << 0 to the answer.

         Test:
         divisor = 0; // overflow
         dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1) // overflow


         Time: O((logn)^2)
         // The outer loop reduces n by at least half each iteration. So It has O(log N) iterations.
         // The inner loop has at most log N iterations. So the overall complexity is O((logN)^2)


         */
        public int divide(int dividend, int divisor) {
            if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
                return Integer.MAX_VALUE;
            int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
            long dvd = Math.abs((long) dividend);
            long dvs = Math.abs((long) divisor);
            int res = 0;
            while (dvd >= dvs) {
                long tmp = dvs, multiple = 1;
                while (dvd >= (tmp << 1)) {
                    tmp <<= 1;
                    multiple <<= 1;
                }
                dvd -= tmp;
                res += multiple;
            }
            return sign == 1 ? res : -res;
        }
    }

    public static class Solution_2 {
        // using subtract
        public int divide(int dividend, int divisor) {
            if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
                return Integer.MAX_VALUE;
            int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
            long dvd = Math.abs((long) dividend);
            long dvs = Math.abs((long) divisor);
            int res = 0;
            while (dvd >= dvs) {
                dvd -= dvs;
                res++;
            }

            return sign == 1 ? res : -res;
        }

    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        Solution_2 solution_2 = new Solution_2();
        System.out.println(solution_1.divide(15,3));
        System.out.println(solution_2.divide(20,3));
    }
}

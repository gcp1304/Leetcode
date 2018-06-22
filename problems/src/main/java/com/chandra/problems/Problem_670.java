package com.chandra.problems;

/**
 * 670. Maximum Swap
 * <p>
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 * <p>
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * <p>
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * <p>
 * Note:
 * The given number is in the range [0, 108]
 */
public class Problem_670 {

    public static class Solution_1 {
        /*
         * Brute Force
         *The number only has at most 8 digits, so there are only
​               8
​​                C  = 28 available swaps. We can easily brute force them all.
​                 2
​
            Time Complexity = O(n^2) - n is number of digits in a given number
         *
         */
        public int maximumSwap(int num) {
            char[] chars = ("" + num).toCharArray();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    max = Math.max(max, swap(("" + num).toCharArray(), i, j));
                }
            }

            return Math.max(num, max);
        }

        private int swap(char[] chars, int i, int j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            return Integer.valueOf(new String(chars));
        }
    }

    public static class Solution_2 {
        public int maximumSwap(int num) {
            char[] chars = ("" + num).toCharArray();
            int left = -1, right = -1;

            // First find a pair which is in increasing order to swap which would lead to higher number.
            // But that's not what we are looking for
            for (int i = 0; i < chars.length - 1; i++) {

                if (chars[i] - '0' < chars[i + 1] - '0') {
                    left = i;
                    right = i + 1;
                    break;
                }
            }

            // If we don't find a pair to swap which means the number is the highest number.
            // Also to think about it as the number with increasing order of digits
            if (left == right) return num;

            // After identifying a pair to swap which doesn't result in our final result,
            // Let's find the max digit which is largest digit after the right index
            for (int i = right; i < chars.length; i++) {
                if (chars[i] - '0' > chars[right] - '0') {
                    right = i;
                }
            }

            // Find the max digit from the left side of left index to swap with
            for (int i = left; i >= 0; i--) {
                if (chars[i] - '0' > chars[left] - '0')
                    left = i;
            }

            swap(chars, left, right);
            return Integer.valueOf(new String(chars));
        }

        private void swap(char[] chars, int i, int j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
    }

    public static void main(String[] args) {
        Problem_670.Solution_1 solution_1 = new Solution_1();
        Problem_670.Solution_2 solution_2 = new Solution_2();

        System.out.println(solution_1.maximumSwap(9973));

        System.out.println(solution_2.maximumSwap(3216978));
    }
}

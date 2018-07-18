package com.chandra.problems;


/**
 * Given a number, find the sum of all the numbers are multiples of 3 or 7 upto the given input number
 */
public class SumOfMultiples {

    // Time - O(n)
    public static class Solution_1 {
        public static int getSum(int n) {
            int sum = 0;
            for (int i = 3; i <= n; i++) {
                if (i % 3 == 0 || i % 7 == 0) sum += i;
            }
            return sum;
        }
    }

    public static class Solution_2 {

        // Time - O(1)
        private static final int THREE = 3;
        private static final int SEVEN = 7;

        public static int getSum(int n) {
            return getMultipleSum(n, THREE) + getMultipleSum(n, SEVEN);
        }

        private static int getMultipleSum(int n, int multiple) {

            // Determine how multiples of muliple present in a given input number
            int numberOfMultiples = n / multiple;

            // Calculate the sum of all the number of multiples present in a given number
            int sumOfNumberOfMultiples = numberOfMultiples * (numberOfMultiples + 1) / 2;

            // finally multiply the multiple with the sum to determine the totalSum of all multiples of multiple
            return sumOfNumberOfMultiples * multiple;
        }
    }

    public static void main(String[] args) {
        System.out.println(SumOfMultiples.Solution_1.getSum(15));
        System.out.println(SumOfMultiples.Solution_2.getSum(15));
    }
}

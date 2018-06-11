package com.chandra.problems;

/**
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

 Note:

 Your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution and you may not use the same element twice.
 Example:

 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

public class Problem_167 {
    public static class Solution_1 {
        // Binary Search - O(nlogn) time, O(1) space
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                int j = bsearch(numbers, target - numbers[i], i+1);
                if (j != -1) return new int[] { i+1, j+1};
            }
            throw new IllegalArgumentException("No two sum solution");
        }

        int bsearch(int[] A, int key, int start) {
            int L = start, R = A.length - 1;
            while (L < R) {
                int M = (L + R) / 2;
                if (A[M] < key) {
                    L = M + 1;
                } else {
                    R = M;
                }
            }
            return (L == R && A[L] == key) ? L : -1;
        }
    }

    /*
    O(n) runtime, O(1) space - Two pointers
    Let's assume we have two pointers pointing to the ith and jth elements, Ai and Aj respectively.
    The sum of Ai and Aj could only fall into one of these three possibilites:
        a. Ai + Aj > target. Increasing i isn't going to help us, as it makes the sum even bigger. Therefore we
            should decrement j.
        b. Ai + Aj < target. Decreasing j isn't going to help us, as it makes the sum even smaller. Therefore we
            should increment i.
        c. Ai + Aj == target, We have found the answer.
     */
    public static class Solution_2 {
        public int[] twoSum(int[] numbers, int target) {
            int i=0, j = numbers.length-1;
            while (i < j) {
                int sum = numbers[i] + numbers[j];
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    return new int[] { i+1, j+1};
                }
            }

            throw new IllegalArgumentException("No two sum solution");
        }
    }
}

package com.chandra.problems;

/**
 * 461. Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 */
public class Problem_461 {
    public static class Solution_1 {
        public int hammingDistance(int x, int y) {
            x = x^y;
            int count = 0;
            while (x > 0) {
                x &= (x-1);
                count++;
            }
            return count;
        }
    }

    public static class Solution_2 {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^= y);
        }
    }

    public static void main(String[] args) {
        Problem_461.Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.hammingDistance(1, 4));
    }
}

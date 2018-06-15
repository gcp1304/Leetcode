package com.chandra.problems;

/**
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 */
public class Problem_38 {
    public static class Solution_1 {
        public String countAndSay(int n) {
            String res = "1";
            for (int i=0;i<n-1;i++) {
                res = generateAndSay(res);
            }
            return res;
        }

        private String generateAndSay(String s) {
            StringBuilder sb = new StringBuilder();
            char[] chs = s.toCharArray();
            for (int i=0;i<chs.length;i++) {
                int count = 1;
                while (i < chs.length-1 && chs[i] == chs[i+1]) {
                    count++;
                    i++;
                }
                sb.append(count).append(chs[i]);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Problem_38.Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.countAndSay(4)); // 1211
    }
}

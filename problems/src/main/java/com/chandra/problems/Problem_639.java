package com.chandra.problems;

/**
 * 639. Decode Ways II
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

 Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

 Also, since the answer may be very large, you should return the output mod 109 + 7.

 Example 1:
 Input: "*"
 Output: 9
 Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 Example 2:
 Input: "1*"
 Output: 9 + 9 = 18
 Note:
 The length of the input string will fit in range [1, 105].
 The input string will only contain the character '*' and digits '0' - '9'.
 */
public class Problem_639 {

    // Checkout - https://leetcode.com/problems/decode-ways-ii/solution/
    public static class Solution_1 {
        private static final int M = 1000000007;
        public int numDecodings(String s) {
            Integer[] memo = new Integer[s.length()];
            return ways(s, s.length()-1, memo);
        }

        private int ways(String s, int i, Integer[] memo) {
            if (i < 0) return 1;

            if (memo[i] != null) return memo[i]; // if we already computed the sub-problem return the result

            if (s.charAt(i) == '*') { // when last char is *
                long res = 9 * ways(s, i-1, memo);

                if (i> 0 && s.charAt(i-1) == '1')  // when last but one char is 1, then 11-19 (9) multiply by rest of the remainder string ways
                    res = (res + 9 * ways(s, i-2, memo)) % M;
                else if(i>0 && s.charAt(i-1) == '2') // when last but one char is 2, then 21-26 (6) multiply by rest of the remainder string ways
                    res = (res + 6 * ways(s, i-2, memo)) % M;
                else if (i>0 && s.charAt(i-1) == '*') // when last but one char is *, then 11-26 (15) multiply by rest of the remainder string ways
                    res = (res + 15 * ways(s, i-2, memo)) % M;

                memo[i] = (int)res; // store the result for future use
                return memo[i];
            }

            long res = (s.charAt(i) == '0') ? 0 : ways(s, i-1, memo);
            if (i > 0 && s.charAt(i-1) == '1')
                res = (res + ways(s, i-2, memo)) % M;
            else if (i > 0 && s.charAt(i-1) == '2' && s.charAt(i) <= 6)
                res = (res + ways(s, i-2, memo)) % M;
            else if (i>0 && s.charAt(i-1) == '*')
                res = (res + (s.charAt(i) <= '6' ? 2 : 1) * ways(s, i-2, memo)) % M; // checking <= 6 is because if it's more than 6 then we can only replace * with 1 for 17 to 19 not with 2 which would lead to 27-29.

            memo[i] = (int) res;
            return memo[i];
        }
    }


    public static class Solution_2 {
        private static final int M = 1000000007;
        public int numDecodings(String s) {
            long[] dp = new long[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '*') {
                    dp[i + 1] = 9 * dp[i];
                    if (s.charAt(i - 1) == '1')
                        dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                    else if (s.charAt(i - 1) == '2')
                        dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                    else if (s.charAt(i - 1) == '*')
                        dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
                } else {
                    dp[i+1] = (s.charAt(i) != '0' ? dp[i] : 0);
                    if (s.charAt(i-1) == '1')
                        dp[i+1] = (dp[i+1] + dp[i-1]) % M;
                    else if (s.charAt(i-1) == '1' && s.charAt(i-2) <= '6')
                        dp[i+1] = (dp[i+1] + dp[i-1]) % M;
                    else if (s.charAt(i-1) == '*')
                        dp[i+1] = (dp[i+1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i-1]) % M;
                }
            }
            return (int) dp[s.length()];
        }
    }

    public static class Solution_3 {
        private static final int M = 1000000007;
        public int numDecodings(String s) {
            long first = 1, second = (s.charAt(0) == '*' ? 9 : s.charAt(0) != '0' ? 1 : 0);
            for (int i=1;i<s.length();i++) {
                long temp = second;

                if (s.charAt(i) == '*') {
                    second = 9 * second;
                    if (s.charAt(i-1) == '1')
                        second = (second + 9 * first) % M;
                    else if (s.charAt(i-1) == '2')
                        second = (second + 6 * first) % M;
                    else if (s.charAt(i-1) == '*')
                        second = (second + 15 * first) % M;
                } else {
                    second = s.charAt(i) == '0' ? 0 : second;
                    if (s.charAt(i-1) == '1')
                        second = (second + first) % M;
                    else if (s.charAt(i-1) == '1' && s.charAt(i) <= '6')
                        second = (second + first) % M;
                    else if (s.charAt(i-1) == '*')
                        second = (second + (s.charAt(i) <= '6' ? 2 : 1) * first) % M;
                }
                first = temp;
            }
            return (int) second;
        }
    }

    public static void main(String[] args) {
        Problem_639.Solution_3 solution_1 = new Solution_3();
        System.out.println(solution_1.numDecodings("12**610"));
    }
}

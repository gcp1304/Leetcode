package com.chandra.problems;

/**
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given a non-empty string containing only digits, determine the total number of ways to decode it.

 Example 1:

 Input: "12"
 Output: 2
 Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 Example 2:

 Input: "226"
 Output: 3
 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class Problem_91 {
    public static class Solution_1 {
        /*
         *
         I used a dp array of size n + 1 to save subproblem solutions.
         dp[0] means an empty string will have one way to decode,
         dp[1] means the way to decode a string of size 1.
         Then check one digit and two digit combination and
         save the results along the way. In the end, dp[n] will be the end result.
         */
        public int numDecodings(String s) {
            if(s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = s.charAt(0) != '0' ? 1 : 0;
            for(int i = 2; i <= n; i++) {
                int first = Integer.valueOf(s.substring(i-1, i));
                int second = Integer.valueOf(s.substring(i-2, i));
                if(first >= 1 && first <= 9) {
                    dp[i] += dp[i-1];
                }
                if(second >= 10 && second <= 26) {
                    dp[i] += dp[i-2];
                }
            }
            return dp[n];
        }
    }

    public static class Solution_2 {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int first = 1, second = 1;
            for (int i=1;i<s.length();i++) {
                if (s.charAt(i) == '0') first = 0;
                int temp = (Integer.parseInt(s.substring(i-1, i+1)) <= 26) ? first + second : first;
                second = first;
                first = temp;
            }

            return first;
        }
    }
}

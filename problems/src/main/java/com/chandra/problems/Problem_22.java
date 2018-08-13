package com.chandra.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class Problem_22 {

    public static class Solution_1 {
        // backtracking
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generate(result, "", 0, 0, n);
            return result;
        }

        private void generate(List<String> result, String temp, int open, int close, int n) {
            if (temp.length() == n*2) {
                result.add(temp);
                return;
            }

            if (open < n) generate(result, temp + "(", open+1, close, n);
            if (close < open) generate(result, temp + ")", open, close+1, n);
        }
    }

    // classic backtracking
    public static class Solution_2 {
        /**
         * Instead of adding '(' or ')' every time as in Approach 1,
         * let's only add them when we know it will remain a valid sequence.
         * We can do this by keeping track of the number of opening and closing brackets we have placed so far.

         We can start an opening bracket if we still have one (of n) left to place.
         And we can start a closing bracket if it would not exceed the number of opening brackets.
         */
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generate(result, new StringBuilder(), n, n, n);
            return result;
        }

        private void generate(List<String> result, StringBuilder temp, int open, int close, int n) {
            if (close < open || open < 0 || close < 0) return;

            if (temp.length() == n * 2) {
                result.add(temp.toString());
                return;
            }

                temp.append("(");
                generate(result, temp, open - 1, close, n);
            temp.setLength(temp.length() - 1);

                temp.append(")");
                generate(result, temp, open, close - 1, n);
            temp.setLength(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.generateParenthesis(3).toString());
    }
}

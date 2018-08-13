package com.chandra.problems;

import java.util.Stack;

/**
 * 224. Basic Calculator
 *
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 Example 1:

 Input: "1 + 1"
 Output: 2
 Example 2:

 Input: " 2-1 + 2 "
 Output: 3
 Example 3:

 Input: "(1+(4+5+2)-3)+(6+8)"
 Output: 23
 Note:
 You may assume that the given expression is always valid.
 Do not use the eval built-in library function.
 */
public class Problem_224 {
    public static class Solution_1 {
        public  static int calculate(String s) {
            int result = 0;

            if (s == null || s.length() == 0) return 0;

            int num = 0, sign = 1;
            Stack<Integer> stack = new Stack<>();
            int i=0;
            while (i < s.length()) {
                char c = s.charAt(i++);
                // get the number from the string
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i++) - '0';
                    }
                    // if we enounter operand
                } else if (c == '+' || c == '-') {
                    result += sign * num; // perform the operation based on previous operand by multiplying by sign
                    // update sign to new operand and reset num to be reused again
                    sign = c == '+' ? 1 : -1;
                    num = 0;
                } else if (c == '(') {
                    // now we enountered open (, so save the previous sign and result and start fresh until you encounter close )
                    stack.push(result);
                    stack.push(sign);
                    //start fresh
                    sign = 1;
                    result = 0;
                } else if (c == ')') {
                    // now perform last operation before close and use this result with previous stored result before open (
                    result += sign * num;
                    // reset
                    num = 0;
                    sign = 1;
                    // use current result with previously store result
                    result = result * stack.pop() + stack.pop();
                }
            }

            // now if num != 0, then we need to use current number
            result += sign * num;
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(Solution_1.calculate(s));
    }
}

package com.chandra.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */

public class Problem_20 {

    // This solution is faster than using stack
    public static class Solution {
        public boolean isValid(String s) {
            if (s == null) return false;
            char[] stack = new char[s.length()];
            int head = 0;
            for (int i=0;i<s.length();i++) {
                char c = s.charAt(i);

                // whenever we encounter open braces we store the respective closer brace and increment the index
                if (c == '(') stack[head++] = ')';
                else if (c == '{') stack[head++] = '}';
                else if (c == '[') stack[head++] = ']';
                // when we encounter close brace then we check the array for same closer brace by decrementing the index
                // if we it doesn't match then we return false, if it matches then we continue.
                else if (head == 0 || c != stack[--head]) return false;
            }
            // check if index is zero or not. If it's zero then it's a valid parenthesis else false
            return head == 0;
        }
    }

    public static class Solution1 {
        public boolean isValid(String s) {

            if (s == null || s.length() == 1) return false;
            Deque<Character> stack = new ArrayDeque<>();

            for (Character c : s.toCharArray()) {
                if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
                if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
                if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
                if (c == '(' || c == '{' || c == '[') stack.push(c);
            }

            return stack.isEmpty();
        }
    }
}

package com.chandra.problems;

import java.util.Stack;

/**
 * 394. Decode String
 *
 * Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Problem_394 {
    public static class Solution_1 {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            Stack<StringBuilder> resStack = new Stack<>();
            Stack<Integer> countStack = new Stack<>();
            int i=0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    int count = 0;
                    while (Character.isDigit(s.charAt(i)))
                        count = count * 10 + s.charAt(i++) - '0';
                    countStack.push(count);
                } else if (c == '[') {
                    resStack.push(new StringBuilder(res));
                    res.setLength(0);
                    i++;
                } else if (c == ']') {
                    StringBuilder temp = resStack.pop();
                    int count = countStack.pop();
                    while (count-- > 0) {
                        temp.append(res.toString());
                    }
                    res = temp;
                    i++;
                } else {
                    res.append(c);
                    i++;
                }
            }

            return res.toString();
        }
    }

    public static void main(String[] args) {
        Problem_394.Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.decodeString("2[abc]3[cd]ef")); //abcabccdcdcdef
    }
}

package com.chandra.problems;

import java.util.*;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * <p>
 * Example 2:
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * <p>
 * Example 3:
 * Input: ")("
 * Output: [""]
 */

public class Problem_301 {

    public static class Solution_1 {
        /*DFS
        // To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix.
        // However, if we remove any one, we will generate duplicates, e.x. s = ()). Thus, we noly remove 1st ) in a series of concecutive )s.
        // After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string.
        // However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicates.
        // For this, we keep tracking the last removal position and only remove ‘)’ after that.
        // Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘? The answer is: do the same from right to left.
        // However a cleverer idea is: reverse the string and reuse the code!
        Time: O(nk), k: # of recursion calls
        Run: e.x."()())()"
        // "()())()" -> "(())()" -> ")())(("
        //			 -> "()()()" -> ")()()("
        // res = ["(())()", "()()()"]
            Test: 	"", // empty
                    ")(", // -> ""
                    "()())()", // normal
                    "(a)())()" // contain non-parenthesis char
        */
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            dfs(res, s, new char[]{'(', ')'}, 0, 0);
            return res;
        }

        private void dfs(List<String> res, String s, char[] p, int iStart, int jStart) {
            // find 1st invalid p[1]
            int stack = 0, i;
            for (i = iStart; i < s.length(); i++) {
                if (s.charAt(i) == p[0]) stack++;
                if (s.charAt(i) == p[1]) stack--;
                // remove each (not consecutive) p[1] from jStart to i to make valid
                if (stack < 0) {
                    for (int j = jStart; j <= i; j++) // <=
                        if (s.charAt(j) == p[1] && (j == jStart || s.charAt(j - 1) != p[1])) {
                            String r = s.substring(0, j) + s.substring(j + 1);
                            dfs(res, r, p, i, j);
                        }
                    return; // important!!
                }
            }
            // stack >= 0 : try reverse s and re-do DFS; if already reversed, then add to res
            String reverse = new StringBuilder(s).reverse().toString();
            if (p[0] == '(')
                dfs(res, reverse, new char[]{')', '('}, 0, 0); // important: 0, 0
            else
                res.add(reverse);
        }
    }

    public static class Solution_2 {
        //BFS -> guarantee the number of parentheses that need to be removed is minimal
        // With the input string s, we generate all possible states by removing one ( or ), check if they are valid,
        // if found valid ones on the current level, put them to res and we are done, otherwise add them to a queue and carry on to the next level
        //Time: T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
        // In BFS we handle the states level by level, in the worst case, we need to handle all the levels,
        // we can analyze the time complexity level by level and add them up to get the final complexity.
        // On the first level, there's only one string which is the input string s, let's say the length of it is n, to check whether it's valid,
        // we need O(n) time. On the second level, we remove one ( or ) from the first level, so there are C(n, n-1) new strings,
        // each of them has n-1 characters, and for each string, we need to check whether it's valid or not, thus the total time complexity
        // on this level is (n-1) x C(n, n-1). Come to the third level, total time complexity is (n-2) x C(n, n-2), so on and so forth...
        //Run: e.x. "(a)())()"
        // q = ["(a)())()"]
        //["a)())()", "(a())()", "(a))()", "(a)()()", "(a)()))", "(a)())("]
        // visited = ["(a)())()", "a)())()", "(a())()", "(a))()", "(a)()()", "(a)()))", "(a)())("]
        // res = ["(a())()", "(a)()()"]
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            if (s == null) return res;
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>(); // avoid duplicate results
            q.offer(s);
            visited.add(s);
            boolean foundValid = false;
            while (!q.isEmpty()) {
                String t = q.poll();
                if (isValid(t)) {
                    res.add(t);
                    foundValid = true;
                }
                // found valid, no need to remove anymore, just iterative the rest of q and add to res when necessary
                if (foundValid) continue;
                for (int i = 0; i < t.length(); i++) {
                    if(t.charAt(i) != '(' && t.charAt(i) != ')')continue;
                    String r = t.substring(0, i) + t.substring(i + 1);
                    if (visited.contains(r)) continue;
                    visited.add(r);
                    q.offer(r);
                }
            }
            return res;
        }

        private boolean isValid(String s) {
            int count = 0; // stack variable
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') count++;
                if (s.charAt(i) == ')' && count-- == 0) return false;
            }
            return count == 0;
        }

        public static void main(String[] args) {
            Solution_1 solution_1 = new Solution_1();
            Solution_2 solution_2 = new Solution_2();

            String input = "()())()";
            System.out.println(solution_1.removeInvalidParentheses(input)); // [(())(), ()()()]
            System.out.println(solution_2.removeInvalidParentheses(input)); // [(())(), ()()()]
        }
    }
}

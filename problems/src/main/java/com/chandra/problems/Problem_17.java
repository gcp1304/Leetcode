package com.chandra.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem_17 {
    public static class Solution1 {
        public List<String> letterCombinations(String digits) {
            LinkedList<String> ans = new LinkedList<>();
            if (digits.isEmpty()) return ans;

            String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            // This is to make sure we start with zero combination
            ans.add("");
            for (int i=0;i<digits.length();i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                // depending on the position of digit we are processing, we loop through the list of elements on position
                // length and append the new char to generate combination
                while(ans.peek().length() == i) {
                    String t = ans.remove();
                    for (char c : mapping[x].toCharArray()) {
                        ans.add(t+c);
                    }
                }
            }
            return ans;
        }
    }

    public static class Solution_2 {
        //DFS
        public List<String> letterCombinations(String digits) {
            String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) return res;
            dfs(res, "", mapping, digits, 0);
            return res;
        }

        private void dfs(List<String> res, String temp, String[] mapping, String digits, int start) {
            if (start == digits.length()) {
                res.add(temp);
                return;
            }

            for (int i = 0; i < mapping[digits.charAt(start) - '0'].length(); i++) {
                dfs(res, temp + mapping[digits.charAt(start) - '0'].charAt(i), mapping, digits, start+1);
            }
        }
    }
}

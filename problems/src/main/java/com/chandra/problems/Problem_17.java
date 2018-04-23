package com.chandra.problems;

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
}

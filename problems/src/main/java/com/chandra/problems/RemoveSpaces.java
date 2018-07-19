package com.chandra.problems;

import java.util.Arrays;

public class RemoveSpaces {
    public static class Solution_1 {
        public static String removeSpaces(String str) {
            char[] chars = str.toCharArray();
            int j=0;
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isWhitespace(chars[i])) {
                    chars[j++] = chars[i];
                }
            }
            return String.valueOf(chars).substring(0, j);
        }

        public static void main(String[] args) {
            System.out.println(Solution_1.removeSpaces("Hi, How are you?"));
        }
    }
}

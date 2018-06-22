package com.chandra.problems;

public class Problem_670 {
    public static class Solution_1 {
        public int maximumSwap(int num) {
            char[] chars = (""+num).toCharArray();
            int l = -1, r = -1;
            for (int i=0;i<chars.length-1;i++) {

                if (chars[i]-'0' < chars[i+1]-'0') {
                    l = i;
                    r = i+1;
                    break;
                }
            }

            for (int i = r; i < chars.length-1; i++) {
                if (chars[i]-'0' > chars[i+1]-'0') r = i;
            }

            for (int i = l; i > 0; i--) {
                if (chars[i]-'0' > chars[i-1]-'0') l = i-1;
            }

            swap(chars, l, r);
            return Integer.valueOf(new String(chars));
        }

        private void swap(char[] chars, int i, int j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
    }

    public static void main(String[] args) {

    }
}

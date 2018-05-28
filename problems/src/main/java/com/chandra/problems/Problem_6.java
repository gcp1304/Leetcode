package com.chandra.problems;


/**
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 *              P   A   H   N
 *              A P L S I I G
 *              Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 *
 * Explanation:
 *          P     I    N
 *          A   L S  I G
 *          Y A   H R
 *          P     I
 */
public class Problem_6 {

    public static class Solution_1 {
        public String convert(String s, int numRows) {


            StringBuilder res = new StringBuilder();

            // Create SB for each row
            StringBuilder[] sbs = new StringBuilder[numRows];
            for (int i=0;i<numRows;i++) {
                sbs[i] = new StringBuilder();
            }

            int i=0;
            while (i < s.length()) {

                // vertically down
                for (int index = 0; index < numRows && i< s.length(); index++) {
                    sbs[index].append(s.charAt(i++));
                }

                // diagonal up
                // why numRows - 2? Because the diagonal starts from last but one row and goes all the upto top second,
                // hence index >= 1
                for (int index = numRows - 2; index >= 1 && i < s.length(); index--) {
                    sbs[index].append(s.charAt(i++));
                }
            }

            // merge all row strings into one and return
            for (StringBuilder sb : sbs) {
                res.append(sb.toString());
            }

            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        System.out.println("Expected: PINALSIGYAHRPI");
        System.out.println(solution_1.convert("PAYPALISHIRING", 4));
    }
}

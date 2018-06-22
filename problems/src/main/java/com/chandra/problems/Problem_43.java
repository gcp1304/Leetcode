package com.chandra.problems;

/**
 * 43. Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class Problem_43 {
    public static class Solution_1 {


        //https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
        public String multiply(String num1, String num2) {
            
            int m = num1.length(), n = num2.length();
            int[] res = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int multiple = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                    int p1 = i+j, p2 = i+j+1;
                    int sum = multiple + res[p2];
                    res[p1] += sum/10; // add carry to sum and create carry for next
                    res[p2] = sum % 10; // store value
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int r : res) if (!(sb.length() == 0 && r == 0)) sb.append(r);
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }

    public static void main(String[] args) {
        String num1="88", num2="88";
        System.out.println(new Problem_43.Solution_1().multiply(num1, num2));
    }
}

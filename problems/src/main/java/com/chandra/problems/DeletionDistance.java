package com.chandra.problems;

/**
 * Deletion Distance
 * The deletion distance of two strings is the minimum number of characters you need to delete in the
 * two strings in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:
 * <p>
 * By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 * We cannot get the same string from both strings by deleting 2 letters or fewer.
 * Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion
 * distance between them. Explain how your function works, and analyze its time and space complexities.
 * <p>
 * Examples:
 * <p>
 * input:  str1 = "dog", str2 = "frog"
 * output: 3
 * <p>
 * input:  str1 = "some", str2 = "some"
 * output: 0
 * <p>
 * input:  str1 = "some", str2 = "thing"
 * output: 9
 * <p>
 * input:  str1 = "", str2 = ""
 * output: 0
 * Constraints:
 * <p>
 * [input] string str1
 * [input] string str2
 * [output] integer
 */
public class DeletionDistance {


    /**
     * Let str1Len and str2Len be the lengths of str1 and str2, respectively.
     * Consider the function: opt(i,j) which returns the deletion distance for the i'th prefix of str1,
     * and the j'th prefix of str2. What we want to do in this solution, is to use dynamic programming in
     * order to build a function that calculates opt(str1Len, str2Len). Notice the following:
     * opt(0,j) = j and opt(i,0) = i
     * <p>
     * This is true because if one string is the empty string, we have no choice but to delete all letters in
     * the other string.
     * <p>
     * If i,j > 0 and str1[i] ≠ str2[j] then opt(i,j) = 1 + min(opt(i-1, j), opt(i, j-1))
     * <p>
     * This holds since we need to delete at least one of the letters str1[i] or str2[j] and
     * the deletion of one of the letters is counted as 1 deletion (hence the 1 in the formula).
     * Then, since we’re left with either the (i-1)'th prefix of str1, or the (j-1)'th prefix of str2,
     * need to take the minimum between opt(i-1,j) and opt(i,j-1).
     * We, therefore, get the equation opt(i,j) = 1 + min(opt(i-1,j), opt(i,j-1)).
     * <p>
     * If i,j > 0 and str1[i] = str2[j], then opt(i,j) = opt(i-1, j-1)
     * <p>
     * This holds since we don’t need to delete the last letters in order to get the same string,
     * we simply use the same deletions we would to the (i-1)'th and (j-1)'th prefixes.
     */
    public static class Solution_1 {
        public int deletionDistance(String str1, String str2) {
            if (str1.length() == 0) return str2.length();
            if (str2.length() == 0) return str1.length();

            if (str1.charAt(0) == str2.charAt(0)) return deletionDistance(str1.substring(1), str2.substring(1));
            return 1 + Math.min(deletionDistance(str1, str2.substring(1)), deletionDistance(str1.substring(1), str2));

        }
    }


    /**
     * After finding the relations above for opt(i,j),
     * we use dynamic programming methods to calculate opt(str1Len, str2Len),
     * i.e. the deletion distance for the two strings,
     * by calculating opt(i,j) for all 0 ≤ i ≤ str1Len, 0 ≤ j ≤ str2Len,
     * and saving previous values for later use:
     * <p>
     * <p>
     * Time Complexity: we have a nested loop that executes O(1) steps at every iteration,
     * thus we the time complexity is O(N⋅M) where N and M are the lengths of str1 and str2, respectively.
     * <p>
     * Space Complexity: we save every value of opt(i,j) in our memo 2D array, which takes O(N⋅M) space,
     * where N and M are the lengths of str1 and str2, respectively.
     */
    public static class Solution_2 {
        public int deletionDistance(String str1, String str2) {
            int[][] dp = new int[str1.length() + 1][str2.length() + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0) dp[i][j] = j;
                    else if (j == 0) dp[i][j] = i;
                    else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[str1.length()][str2.length()];
        }
    }

    public static void main(String[] args) {

        DeletionDistance.Solution_1 solution_1 = new Solution_1();
        DeletionDistance.Solution_2 solution_2 = new Solution_2();

        System.out.println(solution_1.deletionDistance("ab", "ba")); // 2

        System.out.println(solution_2.deletionDistance("ab", "ba")); // 2
    }
}

package com.chandra.problems;

public class Problem_26 {

    public static class Solution1 {

        // Two pointers solution
        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) return 0;
            int j = 0; //current index
            for (int i=1; i < nums.length; i++) { // //iterator thru array
                if (nums[j] != nums[i]) { //new number
                    nums[++j] = nums[i]; //fill current index with new number
                }
            }
            return j+1; // due to zero based index
        }
    }
}

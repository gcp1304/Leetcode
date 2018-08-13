package com.chandra.problems;

import com.chandra.common.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

        0
       / \
     -3   9
     /   /
   -10  5

 */
public class Problem_108 {
    public static class Solution_1 {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length-1);
        }

        private TreeNode helper(int[] nums, int l, int r){
            if (l>r) return null;
            if (l==r) return new TreeNode(nums[l]);
            int mid = (l+r)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, l, mid-1);
            root.right = helper(nums, mid+1, r);
            return root;
        }
    }
}

package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:

 Input:
         2
        / \
       1   3
 Output: true
 Example 2:

        5
       / \
      1   4
         / \
        3   6
 Output: false
 Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 is 5 but its right child's value is 4.
 */
public class Problem_98 {

    // Iterative Solution
    public static class Solution_1 {
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.peek();
                    stack.pop();
                    if (prev != null && prev.val >= root.val) return false;
                    prev = root;
                    root = root.right;
                }
            }
            return true;
        }
    }


    // This solution works for most of the use cases except for one use case when tree has Integer.MIN or Integer.MAX
    // values as node values, that's when solution 3 works because we not set any bounds when we start
    public static class Solution_2 {
        public boolean isValidBST(TreeNode root) {
            return isValidateBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
        }

        public boolean isValidateBST(int lowerBound, int upperBound, TreeNode root) {
            if (root == null) return true;

            if (root.val < lowerBound || root.val > upperBound) return false;
            return isValidateBST(lowerBound, root.val, root.left) && isValidateBST(root.val, upperBound, root.right);

        }
    }

    public static class Solution_3 {
        public boolean isValidBST(TreeNode root) {
            return isValidateBST(null, null, root);
        }

        public boolean isValidateBST(Integer lowerBound, Integer upperBound, TreeNode root) {
            if (root == null) return true;

            if ((lowerBound != null && root.val <= lowerBound) || (upperBound != null && root.val >= upperBound)) return false;
            return isValidateBST(lowerBound, root.val, root.left) && isValidateBST(root.val, upperBound, root.right);

            /* Above conditions can squished into one single line like below
            return root == null || (lowerBound == null || root.val > lowerBound) && (upperBound == null || root.val < upperBound) && isValidateBST(lowerBound, root.val, root.left) && isValidateBST(root.val, upperBound, root.right);
             */

        }
    }
}

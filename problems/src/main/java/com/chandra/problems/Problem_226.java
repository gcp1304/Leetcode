package com.chandra.problems;

import com.chandra.common.TreeNode;

/**
 * 226. Invert Binary Tree
 *
 * Invert a binary tree.

 Example:

 Input:

       4
     /   \
    2     7
   / \   / \
  1   3 6   9

 Output:

        4
      /   \
     7     2
    / \   / \
   9   6 3   1

 Trivia:
 This problem was inspired by this original tweet by Max Howell:

 Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */


public class Problem_226 {
    public static class Solution_1 {
        // DFS Top Down
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;

            TreeNode left = root.left;
            TreeNode right = root.right;

            // switch left subtree and right subtree
            root.left = right;
            root.right = left;

            // continue doing the switching of left subtree and right subtree recursively until we reach the last level
            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }

    public static class Solution_2 {

        // DFS - Bottom Up
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;

            TreeNode invertedLeft = invertTree(root.left);
            TreeNode invertedRight = invertTree(root.right);

            root.left = invertedRight;
            root.right = invertedLeft;

            return root;
        }
    }
}

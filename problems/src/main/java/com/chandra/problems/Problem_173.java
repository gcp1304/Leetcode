package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

public class Problem_173 {
    public static class Solution1 {
        public class BSTIterator {

            /*
             * This is a super cool/clever idea: use a stack to store all the current left nodes of the BST, when pop(), we
             * push all its right nodes into the stack if there are any.
             * This way, we use only O(h) memory for this iterator, this is a huge saving when the tree is huge
             * since h could be much smaller than n. Cheers!
             */

            private Stack<TreeNode> stack;

            public BSTIterator(TreeNode root) {
                stack = new Stack<>();
                pushAll(root);
            }

            /**
             * @return whether we have a next smallest number
             */
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            /**
             * @return the next smallest number
             */
            public int next() {
                TreeNode node = stack.pop();
                pushAll(node.right);
                return node.val;
            }

            private void pushAll(TreeNode node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
}

package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.Stack;

/**
 * Question - Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 */

public class Problem_285 {
    public static class Solution1 {

        // Brute Force - O(n)
        //The most straight-forward solution is to do a in-order traversal of the BST. When we found the target node, we look for the smallest number greater than the node.
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            if (root == null || p == null) return null;

            if (p == root) return root.right;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode q = root;


            while (!stack.isEmpty() || q != null) {
                // Keep pushing left elements from root until we reach leaf node
                if (q != null) {
                    stack.push(q);
                    q = q.left;
                } else {
                    // when no left node is present then pop the element from stack
                    TreeNode curr = stack.pop();
                    // save the next right subtree root to process further
                    q = q.right;

                    // if the current top element on stack is the target node, then
                    if (curr == p) {
                        // return the leftmode element in the right subtree which is the inorder successor
                        if (curr.right != null) {
                            TreeNode m = curr.right;
                            while (m.left != null) {
                                m = m.left;
                            }
                            return m;
                        } else if (!stack.isEmpty()) {
                            // if there's no subtree then the next element in the stack is the successor
                            return stack.pop();
                        }
                    }
                }
            }
            return null;
        }
    }

    public static class Solution_2 {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) return null;

            TreeNode parent = null;
            TreeNode curr = p;
            // check which subtree holds the in-order successor
            while (curr != null && curr.val != p.val) {
                if (curr.val < p.val) {
                    parent = p;
                    curr = p.left;
                } else {
                    curr = p.right;
                }
            }

            // if we reach don't find the given node then return null
            if (curr == null) return null;

            // if there's no right subtree, then parent of node is successor
            if (curr.right == null) return parent;

            // if there's a right subtree of given node, then return the leftmost element as successor
            curr = p.right;
            while (curr.left != null) {
                curr = curr.left;
            }

            return curr;
        }
    }

    public static class Solution_3 {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) return root;

            TreeNode successor = null;
            while (root != null) {
                if (p.val < root.val) {
                    successor = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }

            return successor;
        }
    }


    public static class Solution_4 {
        //recursive of Solution_3
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) return root;

            if (p.val < root.val) {
                TreeNode successor = inorderSuccessor(root.left, p);
                return successor == null ? successor : root;
            } else return inorderSuccessor(root.right, p);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(5);
        node.right = new TreeNode(40);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(10);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(15);

        Solution_3 solution_3 = new Solution_3();
        TreeNode succ = solution_3.inorderSuccessor(node, new TreeNode(15));
        System.out.println(succ.val);

        Solution_4 solution_4 = new Solution_4();
        TreeNode succ1 = solution_4.inorderSuccessor(node, new TreeNode(22));
        System.out.println(succ1.val);
    }
}

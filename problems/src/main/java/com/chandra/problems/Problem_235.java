package com.chandra.problems;


import com.chandra.common.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T
 * that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 *              _______3______
 *             /              \
 *          ___5__          ___1__
 *         /      \        /      \
 *        6      _2       0       8
 *       / \
 *      7   4
 *
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 * Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class Problem_235 {
    public static class Solution1 {
        /*
        If both the given node values are smaller than root node value, then check on left tree
        If both the given node values are greater than root node value, then check on right tree
        Whenever there's a split of node values with root node value, that's the LCA of given nodes
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) return null;

            if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
            return root;
        }
    }
}

package com.chandra.problems;


import com.chandra.common.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).”
                      _______6______
                     /              \
                 ___2__          ___8__
                 /      \        /      \
                 0      _4       7       9
                       /  \
                      3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class Problem_235 {


    public static class Solution1 {
        /* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives
        Just walk down from the whole tree's root as long as both p and q are in the same subtree
        (meaning their values are both smaller or both larger than root's).
        This walks straight from the root to the LCA, not looking at the rest of the tree,
        so it's pretty much as fast as it gets.
         */
        // Iterative
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while ((root.val - p.val) * (root.val - q.val) > 0) // < 0 means each node lie on separate subtree
                root = p.val < root.val ? root.left : root.right;
            return root;
        }
    }

    // Recursive of Solution_1
    public static class Solution_2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if ((root.val - p.val) * (root.val - q.val) <= 0) return root;
            if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static class Solution3 {
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

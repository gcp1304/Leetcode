package com.chandra.problems;

import com.chandra.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *          1
 *        /   \
 *       2     3
 *        \
 *         5
 *
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 */
public class Problem_257 {

    // Dfs Solution
    public static class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if (root == null) return paths;

            dfs(root, paths, "");
            return paths;

        }

        private void dfs(TreeNode node, List<String> paths, String path) {
            if (node == null) return;

            if (node.left == null && node.right == null) {
                paths.add(path + node.val);
                return;
            }

            dfs(node.left, paths, path + node.val + "->");
            dfs(node.right, paths, path + node.val + "->");
        }
    }

    public static class Solution2 {
        // Recursive

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new LinkedList<>();

            if (root == null) return paths;

            if (root.left == null && root.right == null) {
                paths.add(root.val + "");
                return paths;
            }


            // left tree paths
            paths.add(root.val + "->");
            paths.addAll(binaryTreePaths(root.left));

            paths.add(root.val + "->");
            paths.addAll(binaryTreePaths(root.right));


            /*for (String path : binaryTreePaths(root.left)) {
                paths.add(root.val + "->" + path);
            }



            for (String path : binaryTreePaths(root.right)) {
                paths.add(root.val + "->" + path);
            }*/

            return paths;
        }
    }
}

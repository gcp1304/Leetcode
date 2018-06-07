package com.chandra.problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Serialize and deserialize a general tree
 *           A
 *      /    |    \
 *    B      C     D
 *   / \        / | \ \
 *  E   F      I  G  H  J
 *      |
 *      K
 */

public class SerializeAndDeserializeNArrayTree {

    private static class TreeNode {
        char val;
        Map<Character, TreeNode> children;

        public TreeNode(char val) {
            this.val = val;
            children = new LinkedHashMap<>();
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val);
        for (Map.Entry<Character, TreeNode> child : node.children.entrySet()) {
            serializeHelper(child.getValue(), sb);
        }
        sb.append("#");
    }

    private int currentIndex = 0;
    public TreeNode deserialize(String serializedString) {
        if (currentIndex >= serializedString.length()) return null;
        if (serializedString.charAt(currentIndex) == '#') return null;

        TreeNode root = new TreeNode(serializedString.charAt(currentIndex));
        while (currentIndex < serializedString.length()) {
            currentIndex++;
            TreeNode child = deserialize(serializedString);
            if (child == null) break;
            root.children.put(child.val, child);
        }

        return root;

    }

    private void printTree(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);
        for (Map.Entry<Character, TreeNode> child : root.children.entrySet()) {
            printTree(child.getValue());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        root.children.put('B', nodeB);
        TreeNode nodeE = new TreeNode('E');
        nodeB.children.put('E',nodeE);
        TreeNode nodeF = new TreeNode('F');
        nodeB.children.put('F', nodeF);
        TreeNode nodeK = new TreeNode('K');
        nodeF.children.put('K', nodeK);
        TreeNode nodeC = new TreeNode('C');
        root.children.put('C', nodeC);
        TreeNode nodeD = new TreeNode('D');
        root.children.put('D', nodeD);
        TreeNode nodeI = new TreeNode('I');
        nodeD.children.put('I', nodeI);
        TreeNode nodeG = new TreeNode('G');
        nodeD.children.put('G', nodeG);
        TreeNode nodeH = new TreeNode('H');
        nodeD.children.put('H', nodeH);
        TreeNode nodeJ = new TreeNode('J');
        nodeD.children.put('J', nodeJ);


        SerializeAndDeserializeNArrayTree sd = new SerializeAndDeserializeNArrayTree();
        sd.printTree(root);
        String res = sd.serialize(root);
        System.out.println(res);

        TreeNode dRoot = sd.deserialize(res);
        sd.printTree(dRoot);
        System.out.println(sd.serialize(dRoot));
    }
}

package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

public class SerializeDeserializeTree {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodeList = new LinkedList<>();
        nodeList.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodeList);
    }

    private TreeNode buildTree(LinkedList<String> nodes) {
        String val = nodes.remove();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;

    }
}

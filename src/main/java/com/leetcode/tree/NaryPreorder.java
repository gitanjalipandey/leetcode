package com.leetcode.tree;

// https://leetcode.com/problems/n-ary-tree-preorder-traversal/

import com.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryPreorder {
    public List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        return l;
    }

    private void dfs(Node root, List<Integer> l) {
        if (root == null) return;
        l.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), l);
        }
    }
}

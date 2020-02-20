package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-postorder-traversal/

public class PostorderTraverse {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                res.addFirst(root.val);
                root = root.right;
            }
            root = stack.pop();
            if (root != null) root = root.left;
        }

        return res;
    }
}

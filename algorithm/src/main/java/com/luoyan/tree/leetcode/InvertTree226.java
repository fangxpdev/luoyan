package com.luoyan.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree226 {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            swapNode(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

//        invertTree(root.left);
//        swapNode(root);
//        invertTree(root.right);
        return root;
    }

    private static void swapNode(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}

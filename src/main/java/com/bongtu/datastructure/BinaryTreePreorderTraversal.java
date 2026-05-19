package com.bongtu.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        travel(result, root);

        return result;
    }

    private void travel(List<Integer> list, TreeNode node) {
        if (node == null)
            return;
        list.add(node.val);
        travel(list, node.left);
        travel(list, node.right);
    }
    
    public class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;
    
        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

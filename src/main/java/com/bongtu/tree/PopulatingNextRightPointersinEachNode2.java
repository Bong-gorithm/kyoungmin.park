package com.bongtu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode2 {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int s = q.size();
            Node prev = null;

            for (int i = 0; i < s; i++) {
                Node cur = q.poll();

                if(prev != null){
                    prev.next = cur;
                }

                prev = cur;

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
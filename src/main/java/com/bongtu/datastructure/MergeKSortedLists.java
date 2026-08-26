package com.bongtu.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.bongtu.datastructure.MergeKSortedLists.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        if(lists.length == 0) {
            return null;
        }

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode answer = new ListNode(0);
        ListNode current = answer;

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            
            current.next = node;
            current = current.next;

            if(node.next != null) {
                pq.offer(node.next);
            }
        }

        return answer.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

package com.bongtu.datastructure;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode middle = head;

        while (fast.next != null && fast.next.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = middle.next;
        middle.next = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
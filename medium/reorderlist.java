// 143. Reorder List
// Medium
// Topics
// premium lock icon
// Companies
// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Example 1:

// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// Example 2:

// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]

// Constraints:

// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode hare = head;
        ListNode turtle = head;
        ListNode prev = turtle;

        while (hare != null && hare.next != null) {
            prev = turtle;
            turtle = turtle.next;
            hare = hare.next.next;
        }

        prev.next = null;
        ListNode newhead = reverselist(turtle);

        ListNode curr = head;
        ListNode dummy = head;
        while (dummy != null && newhead != null) {
            dummy = dummy.next;
            curr.next = newhead;
            curr = curr.next;
            newhead = newhead.next;
            curr.next = dummy;
            prev = curr;
            curr = curr.next;
        }
        if (dummy != null) {
            prev.next = dummy;
        }
        if (newhead != null) {
            prev.next = newhead;
        }
        // curr.next = null;
        // return dummy;
    }

    ListNode reverselist(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        return prev;
    }
}
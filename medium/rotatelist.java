
// Code
// 61. Rotate List
// Attempted
// Medium
// Topics
// premium lock icon
// Companies
// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:

// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:

// Input: head = [0,1,2], k = 4
// Output: [2,0,1]

// Constraints:

// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109

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
// class Solution {
// public class ListNode {
// int val;
// ListNode next;

// ListNode() {
// }

// ListNode(int val) {
// this.val = val;
// }

// ListNode(int val, ListNode next) {
// this.val = val;
// this.next = next;
// }
// }

// public ListNode rotateRight(ListNode head, int k) {
// if (head == null || head.next == null)
// return head;
// ListNode newhead = helper(head, k);
// return newhead;
// }

// public ListNode helper(ListNode head, int k) {
// while (k != 0) {
// ListNode oldhead = head;
// ListNode prev = null;
// while (head.next != null) {
// if (head.next.next == null) {
// prev = head;
// }
// head = head.next;
// }
// prev.next = null;
// head.next = oldhead;
// k--;
// }
// return head;
// }
// }

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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        int size = getsize(head);
        // int nodes = k > size ? (int) Math.abs((size - k) / size) : size - k;
        int nodes = k % size;

        while (nodes != 0) {
            ListNode temp = head;
            ListNode prev = head;
            while (temp.next != null) {
                if (temp.next.next == null) {
                    prev = temp;
                }
                temp = temp.next;
            }
            prev.next = null;
            temp.next = head;
            head = temp;
            nodes--;
        }
        return head;
    }

    private int getsize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}

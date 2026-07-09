// 206. Reverse Linked List
// Easy
// Topics
// premium lock icon
// Companies
// Given the head of a singly linked list, reverse the list, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:
// Input: head = [1,2]
// Output: [2,1]
// Example 3:
// Input: head = []
// Output: []
// Constraints:
// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000
// Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    // Iterative
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //     ListNode prev = head;
    //     ListNode curr = head.next;

    //     while (curr != null) {
    //         ListNode next = curr.next;

    //         curr.next = prev;

    //         //update
    //         prev = curr;
    //         curr = next;
    //     }

    //     head.next = null;
    //     head = prev;
    // }

    // recursive

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }
}

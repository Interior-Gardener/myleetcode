// 2487. Remove Nodes From Linked List
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given the head of a linked list.

// Remove every node which has a node with a greater value anywhere to the right side of it.

// Return the head of the modified linked list.

// Example 1:

// Input: head = [5,2,13,3,8]
// Output: [13,8]
// Explanation: The nodes that should be removed are 5, 2 and 3.
// - Node 13 is to the right of node 5.
// - Node 13 is to the right of node 2.
// - Node 8 is to the right of node 3.
// Example 2:

// Input: head = [1,1,1,1]
// Output: [1,1,1,1]
// Explanation: Every node has value 1, so no nodes are removed.

// Constraints:

// The number of the nodes in the given list is in the range [1, 105].
// 1 <= Node.val <= 105

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

import java.util.*;
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

    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        boolean[] temp = new boolean[list.size()];
        int max = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) < max) {
                temp[i] = true;
            }
            max = Math.max(max, list.get(i));
        }
        // System.out.println(list);
        // printArr(temp);

        ListNode dummy = new ListNode();
        // dummy.next = head;
        // ListNode dummy = head;
        ListNode newhead = head;
        curr = head;
        int i = 0;
        boolean first = false;
        while (curr != null && i < temp.length) {
            if (temp[i]) {
                curr = curr.next;
                i++;
                continue;
            } else {

                dummy.next = curr;
                dummy = dummy.next;
                curr = curr.next;
                i++;
                if (!first) {
                    newhead = dummy;
                    // System.out.println(newhead.val);
                    first = true;
                }
            }
        }
        // dummy.next = null;
        return newhead;
    }

    // void printArr(boolean[] temp) {
    // for (int i = 0; i < temp.length; i++) {
    // System.out.print(temp[i] + " ");
    // }
    // System.out.println();
    // }
}
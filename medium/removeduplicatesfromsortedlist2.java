// 82. Remove Duplicates from Sorted List II
// Medium
// Topics
// premium lock icon
// Companies
// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

// Example 1:

// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]
// Example 2:

// Input: head = [1,1,1,2,3]
// Output: [2,3]

// Constraints:

// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode curr = head.next;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (curr != null) {
            map.put(prev.val, 1);
            if (map.containsKey(curr.val)) {
                int count = 0;
                while (curr != null && map.containsKey(curr.val)) {
                    count++;
                    curr = curr.next;
                }
                map.put(prev.val, map.get(prev.val) + count);
                if (curr == null) {
                    prev.next = null;
                    break;
                }
            }
            prev.next = curr;
            prev = curr;
            curr = curr.next;
        }
        while (true) {
            if (head != null && map.getOrDefault(head.val, 0) > 1)
                head = head.next;
            else
                break;
        }
        if (head == null || head.next == null)
            return head;
        prev = head;
        curr = head.next;
        while (curr != null) {
            if (map.getOrDefault(curr.val, 0) > 1) {
                while (curr != null && map.getOrDefault(curr.val, 0) > 1) {
                    curr = curr.next;
                }
                if (curr == null) {
                    prev.next = null;
                    break;
                } else {
                    prev.next = curr;
                }
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
// 142. Linked List Cycle II
// Medium
// Topics
// premium lock icon
// Companies
// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.
// Example 2:

// Input: head = [1,2], pos = 0
// Output: tail connects to node index 0
// Explanation: There is a cycle in the linked list, where tail connects to the first node.
// Example 3:

// Input: head = [1], pos = -1
// Output: no cycle
// Explanation: There is no cycle in the linked list.

// Constraints:

// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list.

// Follow up: Can you solve it using O(1) (i.e. constant) memory?

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
// import java.util.*;

// class Solution {
//     class ListNode {
//         int val;
//         ListNode next;

//         ListNode(int x) {
//             val = x;
//             next = null;
//         }
//     }

//     public ListNode detectCycle(ListNode head) {
//         ListNode head2 = null;
//         ListNode temp = head;
//         while (temp != null) {
//             System.out.println("while");
//             if (isPresent(temp, head2))
//                 return temp;
//             head2 = addLL(head2, temp);
//             temp = temp.next;
//         }
//         return null;
//     }

//     public ListNode addLL(ListNode head, ListNode temp) {
//         System.out.println("addLL");
//         ListNode temp2 = new ListNode(temp.val);
//         temp2.next = null;
//         if (head == null) {
//             head = temp2;
//             head.next = null;
//             return head;
//         }
//         ListNode t = head;
//         while (t.next != null) {
//             t = t.next;
//         }
//         t.next = temp2;
//         t = t.next;
//         t.next = null;
//         return head;
//     }

//     public boolean isPresent(ListNode temp, ListNode head) {
//         System.out.println("here");
//         if (head == null)
//             return false;
//         ListNode t = head;
//         while (t != null) {
//             if (t == temp) {
//                 return true;
//             }
//             t = t.next;
//         }
//         return false;
//     }
// }

// /**
//  * Definition for singly-linked list.
//  * class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// import java.util.*;
// public class Solution {
//         class ListNode {
//         int val;
//         ListNode next;

//         ListNode(int x) {
//             val = x;
//             next = null;
//         }
//     }
//     public ListNode detectCycle(ListNode head) {
//         if(head == null) return head;
//         HashSet<ListNode> set = new HashSet<>();
//         ListNode temp = head;
//         while(temp!=null){
//             if(set.contains(temp)) return temp;
//             else set.add(temp);
//             temp = temp.next;
//         }
//         return null;
//     }
// }

class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode detectCycle(ListNode head) {

            ListNode turtle = head;
            ListNode hare = head;

            while (hare != null && hare.next != null) {
                turtle = turtle.next;
                hare = hare.next.next;

                if (turtle == hare) {

                    ListNode temp = head;

                    while (temp != turtle) {
                        temp = temp.next;
                        turtle = turtle.next;
                    }

                    return temp;
                }
            }

            return null;
        }
    }
}
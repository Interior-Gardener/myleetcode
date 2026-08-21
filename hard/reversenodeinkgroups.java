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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        Deque<ListNode> q = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        boolean first = true;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            int temp = k;
            while (curr != null && temp != 0) {
                q.offerLast(curr);
                curr = curr.next;
                temp--;
            }
            if (temp != 0)
                break;

            prev.next = q.peekLast();

            while (q.size() != 1) {
                ListNode node = q.pollLast();
                // System.out.println(node.val + " << value");
                node.next = q.peekLast();
                if(q.size() == 1) prev = q.peek();
            }
            ListNode node = q.pollLast();
            // System.out.println(node.val + " << value");
            node.next = curr;
            // printLL(dummy.next);
            first = false;

        }

        return dummy.next;
    }

    static void printLL(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }
}
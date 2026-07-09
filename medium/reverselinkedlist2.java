// 92. Reverse Linked List II
// Medium
// Topics
// premium lock icon
// Companies
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
// Example 2:
// Input: head = [5], left = 1, right = 1
// Output: [5]
// Constraints:
// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
// Follow up: Could you do it in one pass?
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

    public static class ListNode {

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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }

    public static ListNode insertinLL(ListNode head, int data) {
        ListNode newnode = new ListNode(data, null);
        if (head == null) {
            return newnode;
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
        return head;
    }

    public static void printLL(ListNode head) {
        if (head == null) {
            System.out.print("NULL");
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // public static ListNode reverseBetween(ListNode head, int left, int right) {
    // if(head == null || head.next == null) {
    //     return head;
    // }
    // LinkedList<Integer> templist = new LinkedList<>();
    // ListNode temp = head;
    // while (temp != null) {
    //     if (temp.val == left) {
    //         while (temp.val != right) {
    //             templist.addLast(temp.val);
    //             temp = temp.next;
    //         }
    //         templist.addLast(temp.val);
    //         break;
    //     }
    //     temp = temp.next;
    // }
    // LinkedList<Integer> reversedlist = templist.reversed();
    // System.out.println(reversedlist + "  Reversed list  1");
    // ListNode temp1 = head;
    // while (temp1 != null) {
    //     System.out.println(reversedlist + "  Reversed list  2");
    //     if (temp1.val == left) {
    //         System.out.println(reversedlist + "  Reversed list  3");
    //         while (temp1.val != right) {
    //             System.out.println(reversedlist + "  Reversed list  4");
    //             temp1.val = reversedlist.getFirst();
    //             reversedlist.removeFirst();
    //             temp1 = temp1.next;
    //             System.out.println(reversedlist + "  Reversed list  5");
    //         }
    //         System.out.println(reversedlist + "  Reversed list  6");
    //         temp1.val = reversedlist.getFirst();
    //         // temp1 = temp1.next;
    //         System.out.println(reversedlist + "  Reversed list  7");
    //         break;
    //     }
    //     System.out.println(reversedlist + "  Reversed list  8");
    //     temp1 = temp1.next;
    // }
    // System.out.println(reversedlist + "  Reversed list  9");
    // return head;
    // }
    // public ListNode reverseBetween(ListNode head, int left, int right) {
    //     LinkedList<Integer> templist = new LinkedList<>();
    //     ListNode temp = head;
    //     int count = 1;
    //     while (count <= right && temp != null) {
    //         if (count == left) {
    //             while (count != right) {
    //                 templist.addLast(temp.val);
    //                 count++;
    //                 temp = temp.next;
    //             }
    //             templist.addLast(temp.val);
    //             break;
    //         }
    //         count++;
    //         temp = temp.next;
    //     }
    //     LinkedList<Integer> reversedlist = templist.reversed();
    //     count = 0;
    //     ListNode rightofright = new ListNode();
    //     ListNode temp1 = head;
    //     while(temp1 != null){
    //         if(count == right){
    //             if(temp1.next != null){
    //                 temp1 = temp1.next;
    //                 rightofright.val = temp1.val;
    //                 if(temp1.next != null) rightofright.next = temp1.next;
    //                 else rightofright.next = null;
    //                 break;
    //             }
    //         }
    //         count++;
    //         temp1 = temp1.next;
    //     }
    //     temp1 = head;
    //     count=1;
    //     while(temp1 != null){
    //         if(left == 1){
    //             head = reversedlist.getFirst();
    //             while
    //         }
    //     }
    //     return head;
    // }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        // if (head.next.next == null ){

        // }
        ListNode temp = head;
        ListNode prevtemp = temp;
        int count = 1;
        while (temp != null) {
            if (count == left) {
                break;
            }
            count++;
            prevtemp = temp;
            temp = temp.next;
        }
        // System.out.println("1 while done");
        ListNode righttemp = head;
        int count2 = 1;
        while (true) {
            if (count2 == right) {
                if (righttemp.next == null) {
                    righttemp = null; 
                }else {
                    righttemp = righttemp.next;
                }
                break;
            }
            count2++;
            if (righttemp != null) {
                righttemp = righttemp.next;
            }
        }
        // System.out.println("2 while done" + " " + temp.val + " " + prevtemp.val + " " + righttemp.val);
        while (true) {
            // printLL(head);
            ListNode prev = temp;
            ListNode curr = temp.next;
            // System.out.println("prev curr " + prev.val + " " + curr.val + " ");
            while (count <= right) {
                // printLL(head);
                ListNode next = curr.next;
                // System.out.println("next.val!!!" + next.val);
                curr.next = prev;
                // System.out.println("prev curr next " + prev.val + " " + curr.val + " " + next.val);
                prev = curr;
                curr = next;
                count++;
                // System.out.println("prev curr next " + prev.val + " " + curr.val + " " + next.val);
                // System.out.println("prev curr next finally " + prev.val + " " + curr.val + " " + next.val);
                if (count == right) {
                    break;
                }
                // printLL(head);
            }
            prevtemp.next = prev;
            temp.next = righttemp;
            if (prevtemp == temp)
            head = prev;
            // printLL(head);
            break;
        }
        // System.out.println("3 while done");
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        // int[] arr = {3, 5};
        ListNode head = null;
        for (int i = 0; i < arr.length; i++) {
            head = insertinLL(head, arr[i]);
        }
        printLL(head);
        // head = reverseBetween(head, 2, 4);
        head = reverseBetween(head, 1, 2);
        printLL(head);
    }
}

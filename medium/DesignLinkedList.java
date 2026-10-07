// 707. Design Linked List
// Medium
// Topics
// premium lock icon
// Companies
// Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
// A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
// If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

// Implement the MyLinkedList class:

// MyLinkedList() Initializes the MyLinkedList object.
// int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
// void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
// void addAtTail(int val) Append a node of value val as the last element of the linked list.
// void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
// void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

// Example 1:

// Input
// ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
// [[], [1], [3], [1, 2], [1], [1], [1]]
// Output
// [null, null, null, null, 2, null, 3]

// Explanation
// MyLinkedList myLinkedList = new MyLinkedList();
// myLinkedList.addAtHead(1);
// myLinkedList.addAtTail(3);
// myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
// myLinkedList.get(1);              // return 2
// myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
// myLinkedList.get(1);              // return 3
 

// Constraints:

// 0 <= index, val <= 1000
// Please do not use the built-in LinkedList library.
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.

class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode dummy = new ListNode();
    int size = 0;
    ListNode tail = dummy;

    public MyLinkedList() {

    }

    public int get(int i) {
        // int size = size(dummy.next);
        if (i >= size) {
            return -1;
        }
        ListNode curr = dummy.next;
        while (i > 0) {
            i--;
            curr = curr.next;
        }
        // printlist(dummy.next);
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = dummy.next;
        dummy.next = temp;
        // printlist(dummy.next);
        size++;
        if (size == 1) {
            tail = dummy.next;
        }
    }

    public void addAtTail(int val) {
        // int size = size(dummy.next);
        // if(size == 0) {
        //     addAtHead(val);
        //     return;
        // }
        // ListNode curr = dummy.next;
        // while(curr.next != null) {
        //     curr = curr.next;
        // }
        ListNode temp = new ListNode(val);
        // curr.next = temp;
        if (size == 0) {
            tail = temp;
            dummy.next = temp;
            size++;
            return;
        }
        tail.next = temp;
        tail = tail.next;
        // printlist(dummy.next);
        size++;
    }

    public void addAtIndex(int i, int val) {
        // int size = size(dummy.next);
        if (i > size) {
            return;
        }
        if (i == size) {
            addAtTail(val);
            return;
        }
        if (i == 0) {
            addAtHead(val);
            return;
        }
        ListNode prev = dummy.next;
        ListNode curr = prev;
        while (i > 0) {
            prev = curr;
            curr = curr.next;
            i--;
        }
        ListNode temp = new ListNode(val);
        prev.next = temp;
        temp.next = curr;
        // printlist(dummy.next);
        size++;
    }

    public void deleteAtIndex(int i) {
        if (i >= size)
            return;
        if (i == 0) {
            // System.out.println(dummy.next.val + " here");
            dummy.next = dummy.next.next;
            size--;
            if (size == 0)
                tail = dummy;
            return;
        }
        // boolean yes = false;
        // if(i == size) yes = true;
        ListNode prev = dummy.next;
        ListNode curr = prev;
        while (i > 0) {
            prev = curr;
            curr = curr.next;
            i--;
        }
        if (curr == null) {
            prev.next = null;
            size--;
            tail = prev;
            return;
        }
        prev.next = curr.next;
        if (curr == tail) {
            tail = prev;
        }
        // if(yes){
        //     tail = prev;
        // }
        // printlist(dummy.next);
        size--;
    }

    // public int size(ListNode head) {
    //     ListNode curr = head;
    //     int len = 0;
    //     while(curr != null) {
    //         len++;
    //         curr = curr.next;
    //     }
    //     printlist(dummy.next);
    //     return len;
    // }

    // public void printlist(ListNode head) {
    //     ListNode curr = head;
    //     while (curr != null) {
    //         System.out.print(curr.val + " ");
    //         curr = curr.next;
    //     }
    //     System.out.println();

    // }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
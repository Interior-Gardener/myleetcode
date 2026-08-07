// Reverse first K of a Queue
// Solved
// Difficulty: EasyAccuracy: 81.28%Submissions: 195K+Points: 2
// Given an integer k and a queue of integers, we need to reverse the order of the first k elements of the queue, leaving the other elements in the same relative order.

// Only following standard operations are allowed on queue.

// enqueue(x) : Add an item x to rear of queue
// dequeue() : Remove an item from front of queue
// size() : Returns number of elements in queue.
// front() : Finds front item.
// Note: 

// The above operations represent the general processings.
// In-built functions of the respective languages can be used to solve the problem.
// If the size of queue is smaller than the given k , then return the original queue.
// Examples:

// Input: q = [1, 2, 3, 4, 5], k = 3
// Output: [3, 2, 1, 4, 5]
// Explanation: After reversing the first 3 elements from the given queue the resultant queue will be [3, 2, 1, 4, 5]
// Input: q = [4, 3, 2, 1], k = 4
// Output: [1, 2, 3, 4] 
// Explanation: After reversing the first 4 elements from the given queue the resultant queue will be [1, 2, 3, 4] 
// Constraints:

// 1 ≤ q.size() ≤ 105
// 1 ≤ q[i] ≤ 105
// 1 ≤ k ≤ 105

import java.util.*;
class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if(q.size() < k) return q;
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0 ; i< k ;i++) {
            st.push(q.poll());
        }
        while(!st.isEmpty()) {
            q.offer(st.pop());
        }
        for(int i = 0 ; i < (q.size() - k) ;i++) {
            q.offer(q.poll());
        }
         return q;
    }
}
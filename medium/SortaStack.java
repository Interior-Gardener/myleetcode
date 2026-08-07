// Sort a stack
// Solved
// Difficulty: MediumAccuracy: 69.19%Submissions: 186K+Points: 4Average Time: 20m
// Given a stack of integers st[]. Sort the stack in ascending order (smallest element at the bottom and largest at the top).

// Examples:

// Input: st[] = [41, 3, 32, 2, 11]
// Output: [41, 32, 11, 3, 2]
// Explanation: After sorting, the smallest element (2) is at the bottom and the largest element (41) is at the top.

// Input: st[] = [3, 2, 1]
// Output: [3, 2, 1]
// Explanation: The stack is already sorted in ascending order.

// Constraints:
// 1 ≤ st.size() ≤ 103
// 0 ≤ stack element ≤ 103 

import java.util.*;
class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        int[] arr = new int[st.size()];
        int j = 0;
        while(!st.isEmpty()) {
            arr[j] = st.pop();
            j++;
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length ;i++) {
            st.push(arr[i]);
        }
    }
}
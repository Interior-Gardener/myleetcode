// 32. Longest Valid Parentheses
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

 

// Example 1:

// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
// Example 2:

// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
// Example 3:

// Input: s = ""
// Output: 0
 

// Constraints:

// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.
import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            }
            else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                }
                else {
                    int length = i - st.peek();
                    longest = Math.max(longest, length);
                }
            }
        }
        return longest;
    }
}
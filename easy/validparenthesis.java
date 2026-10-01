// 20. Valid Parentheses
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"

// Output: true

// Example 2:

// Input: s = "()[]{}"

// Output: true

// Example 3:

// Input: s = "(]"

// Output: false

// Example 4:

// Input: s = "([])"

// Output: true

// Example 5:

// Input: s = "([)]"

// Output: false

 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

import java.util.*;
class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                s.push(c);
            else if (c == ')') {
                if (!s.isEmpty() && s.peek() == '(')
                    s.pop();
                else
                    return false;
            } else if (c == ']') {
                if (!s.isEmpty() && s.peek() == '[')
                    s.pop();
                else
                    return false;
            } else {
                if (!s.isEmpty() && s.peek() == '{')
                    s.pop();
                else
                    return false;
            }
        }
        return s.isEmpty();
    }
}
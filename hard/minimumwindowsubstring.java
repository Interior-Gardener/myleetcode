// 76. Minimum Window Substring
// Attempted
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 

// Constraints:

// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
 

// Follow up: Could you find an algorithm that runs in O(m + n) time?

import java.util.*;
// class Solution {
//     public String minWindow(String s, String t) {
//         int m = s.length();
//         int n = t.length();
//         if (m < n)
//             return "";
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             map.put(t.charAt(i), -1);
//         }
//         for (int i = 0; i < n; i++) {
//             if (map.containsKey(s.charAt(i))) {
//                 map.put(s.charAt(i), i);
//             }
//         }
//         int i = 1, j = n;
//         while (j < m && i < m) {
//             if (map.containsKey(s.charAt(j))) {
//                 map.put(s.charAt(j), j);
//             }
//             i++;
//             j++;
//         }
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         for (int k : map.values()) {
//             if (k == -1)
//                 return "";
//             if (k < min)
//                 min = k;
//             if (k > max)
//                 max = k;
//         }
//         return s.substring(min, max + 1);
//     }
// }
// Attemp 1 failed 


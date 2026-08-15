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

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m)
            return "";
        int[] freqt = new int[52];
        int[] freqs = new int[52];
        for (char c : t.toCharArray()) {
            if (Character.isUpperCase(c)) {
                freqt[c - 'A' + 26]++;
            } else {
                freqt[c - 'a']++;
            }
        }
        int i = 0, j = 0;
        int count = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        while (j < m) {
            char c = s.charAt(j);
            int index;
            if (Character.isUpperCase(c)) {
                index = c - 'A' + 26;
            } else {
                index = c - 'a';
            }
            freqs[index]++;
            if (freqs[index] <= freqt[index]) {
                count++;
            }
            while (count == n) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    start = i;
                }
                char left = s.charAt(i);
                if (Character.isUpperCase(left)) {
                    index = left - 'A' + 26;
                } else {
                    index = left - 'a';
                }
                freqs[index]--;
                if (freqs[index] < freqt[index]) {
                    count--;
                }
                i++;
            }
            j++;
        }

        if (minLength == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start + minLength);
    }
}
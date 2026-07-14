// 1910. Remove All Occurrences of a Substring
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

// Find the leftmost occurrence of the substring part and remove it from s.
// Return s after removing all occurrences of part.

// A substring is a contiguous sequence of characters in a string.

// Example 1:

// Input: s = "daabcbaabcbc", part = "abc"
// Output: "dab"
// Explanation: The following operations are done:
// - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
// - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
// - s = "dababc", remove "abc" starting at index 3, so s = "dab".
// Now s has no occurrences of "abc".
// Example 2:

// Input: s = "axxxxyyyyb", part = "xy"
// Output: "ab"
// Explanation: The following operations are done:
// - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
// - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
// - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
// - s = "axyb", remove "xy" starting at index 1 so s = "ab".
// Now s has no occurrences of "xy".

// Constraints:

// 1 <= s.length <= 1000
// 1 <= part.length <= 1000
// s​​​​​​ and part consists of lowercase English letters.

class Solution {
    // public static String removeOccurrences(String s, String part) {
    // if(part.length() == 0 || part.length() > s.length() || s.length() == 0)
    // return s;

    // for (int i = 0; i < s.length(); i++) {
    // int j = i + part.length() - 1;
    // if (j < s.length()) {
    // if (s.substring(i, j + 1).equals(part)) {
    // s = s.substring(0, i) + s.substring(j + 1, s.length());
    // System.out.println(s + " >s");
    // i = -1;
    // }
    // }

    // }
    // return s;
    // }

    class Solution {
        public static String removeOccurrences(String s, String part) {
            StringBuilder sb = new StringBuilder();
            int partLen = part.length();

            for (char c : s.toCharArray()) {
                sb.append(c);

                if (sb.length() >= partLen) {
                    if (sb.substring(sb.length() - partLen).equals(part)) {
                        sb.delete(sb.length() - partLen, sb.length());
                    }
                }
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // String s = "daabcbaabcbc", part = "abc";
        String s = "axxxxyyyyb", part = "xy";

        System.out.println(removeOccurrences(s, part));
    }
}
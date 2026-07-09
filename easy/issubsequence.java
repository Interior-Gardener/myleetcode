
// Code
// Testcase
// Testcase
// Test Result
// 392. Is Subsequence
// Easy
// Topics
// premium lock icon
// Companies
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false
 

// Constraints:

// 0 <= s.length <= 100
// 0 <= t.length <= 104
// s and t consist only of lowercase English letters.

class Solution {
    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        // if(t.length() == 0) retunr false;

        int i = 0;
        for (int j = 0 ;j <t.length() ; j++){
            if(s.charAt(i) == t.charAt(j)){
                if(i == s.length()-1) return true;
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {


        // String s = "abc", t = "ahbgdc";
        String s = "bfhjk", t = "";
        // String s = "", t = "abcd";
        // String s = "axc", t = "ahbgdc";
        

        System.out.println(isSubsequence(s, t));
    }
}
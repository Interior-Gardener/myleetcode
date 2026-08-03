// 131. Palindrome Partitioning
// Medium
// Topics
// premium lock icon
// Companies
// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        StringBuilder temp = new StringBuilder();
        helper(res, s, 0, n, temp);
        return res;
    }

    public void helper(List<List<String>> res, String s, int index, int n,  StringBuilder temp) {
        if(isPlindrome(temp)) {
            res.add(temp.toString());
            
        }
        for(int i = index; i < n ; i++) {
            temp.append(s.charAt(i));
            helper(res, s, i + 1, n, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
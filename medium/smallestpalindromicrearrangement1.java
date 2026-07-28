// 3517. Smallest Palindromic Rearrangement I
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a palindromic string s.

// Return the lexicographically smallest palindromic permutation of s.

 

// Example 1:

// Input: s = "z"

// Output: "z"

// Explanation:

// A string of only one character is already the lexicographically smallest palindrome.

// Example 2:

// Input: s = "babab"

// Output: "abbba"

// Explanation:

// Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.

// Example 3:

// Input: s = "daccad"

// Output: "acddca"

// Explanation:

// Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.

 

// Constraints:

// 1 <= s.length <= 105
// s consists of lowercase English letters.
// s is guaranteed to be palindromic.

class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() < 2) return s;
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length()/2 ;i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();

        for(int i = 0 ; i < freq.length ;i++) {
            if(freq[i] != 0) {
                while(freq[i] != 0 ) {
                    res.append((char)(i + 'a'));
                    freq[i]--;
                }
            }
        }
        int i = 0;
        if(s.length() % 2 != 0) {
            res.append(s.charAt(s.length()/2));
            i = res.length() - 2;
        }
        else {
            i = res.length() -1;
        }

        while(i >=0) {
            res.append(res.charAt(i));
            i--;
        }

        return res.toString();
    }
}
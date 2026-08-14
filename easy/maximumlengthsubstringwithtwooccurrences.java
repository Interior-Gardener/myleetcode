// 3090. Maximum Length Substring With Two Occurrences
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character.
 

// Example 1:

// Input: s = "bcbbbcba"

// Output: 4

// Explanation:

// The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".
// Example 2:

// Input: s = "aaaa"

// Output: 2

// Explanation:

// The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".
 

// Constraints:

// 2 <= s.length <= 100
// s consists only of lowercase English letters.

class Solution {
    public int maximumLengthSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int[] freq = new int[26];
        int i = 0 , j = 0;
        while( j < s.length() && i < s.length()){
            freq[s.charAt(j) - 'a']++;
            sb.append(s.charAt(j));
            if(no2(freq)) {
                if(max < sb.length())
                max = sb.length();
            }
            else {
                freq[s.charAt(i) - 'a']--;
                sb.deleteCharAt(0);
                i++;
                j++;
                continue;
            }
            j++;
        }
        return max;
    }
    public boolean no2(int[] freq) {
        for(int i = 0 ; i < 26 ;i++) {
            if(freq[i] > 2) return false;
        }
        return true;
    }
}
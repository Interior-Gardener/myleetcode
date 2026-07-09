// 409. Longest Palindrome
// Easy
// Topics
// premium lock icon
// Companies
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

// Example 1:

// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
// Example 2:

// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

// Constraints:

// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.

class Solution {
    public static int longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();

        int lp = 0;

        int[] freq = new int[52];

        for(int i = 0 ; i < s.length() ; i++){
            if(Character.isLowerCase(s.charAt(i)))
                freq[s.charAt(i)-'a']++;

            else if (Character.isUpperCase(s.charAt(i)))
                freq[s.charAt(i) - 'A' + 26]++;
        }
        
        boolean oddpresent = false;
        for(int i = 0 ; i<freq.length ; i++){
            if(freq[i]%2 == 0){
                lp+= freq[i];
            }

            else if(freq[i]%2 == 1) {
                oddpresent = true;
                lp+=(freq[i]-1);
            }
        }

        if(oddpresent) return lp+1;
        return lp;
    }

    public static void main(String[] args) {
        // String s = "a";
        // String s = "acdcccd";
        // String s = "aabbcc";
        // String s = "";
        // String s = "aA";
        // String s = "AAABBB";
        // String s = "AAABBC ";
        String s = "AAABBCc";

        System.out.println(longestPalindrome(s));
    }
}
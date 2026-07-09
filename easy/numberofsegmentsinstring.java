// 434. Number of Segments in a String
// Easy
// Topics
// premium lock icon
// Companies
// Given a string s, return the number of segments in the string.

// A segment is defined to be a contiguous sequence of non-space characters.

 

// Example 1:

// Input: s = "Hello, my name is John"
// Output: 5
// Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
// Example 2:

// Input: s = "Hello"
// Output: 1
 

// Constraints:

// 0 <= s.length <= 300
// s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
// The only space character in s is ' '.

class Solution {
    public static int countSegments(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1 && s.charAt(0) != ' ') return 1;

        int segment = 1;
        for(int i = 0 ; i<s.length() ; i++){
            // System.out.println("eneterd for>>>> & val of i in for>>"+i);
            if(s.charAt(i) != ' ') {
                while(i<s.length() && s.charAt(i) != ' '){
                    // System.out.println("VAL of i >" + i);
                    i++;
                }
                segment++;
                i--;
            }
            // System.out.println("for end");
            if(i == s.length()-1) break;
        }
        return segment-1;
    }

    public static void main(String[] args) {
        // String s = "a  Hello, my name is John  bee";
        // String s = "aaaaaaaaaaa";
        String s = " ";

        System.out.println(countSegments(s));
    }
}
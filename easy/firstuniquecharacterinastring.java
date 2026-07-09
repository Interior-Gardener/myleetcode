
// Topics
// premium lock icon
// Companies
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

// Example 1:
// Input: s = "leetcode"
// Output: 0
// Explanation:
// The character 'l' at index 0 is the first character that does not occur at any other index.
// Example 2:
// Input: s = "loveleetcode"
// Output: 2
// Example 3:
// Input: s = "aabb"
// Output: -1
// Constraints:
// 1 <= s.length <= 105
// s consists of only lowercase English letters.
class Solution {

    // public static int firstUniqChar(String s) {
    //     int[] chararr = new int[26];
    //     for (char c : s.toCharArray()) {
    //         chararr[c - 'a']++;
    //     }
    //     System.out.println(Arrays.toString(chararr));
    //     char uniqchar = 0;
    //     for (int i = 0; i < chararr.length; i++) {
    //         if (chararr[i] == 1) {
    //             uniqchar = (char) (i + 'a');
    //             break;
    //         }
    //         if(i == chararr.length - 1) return -1;
    //     }

    //     for (int i = 0; i < s.length(); i++) {
    //         if (uniqchar == s.charAt(i)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // public static int firstUniqChar(String s) {
    //     // int index = -1;
    //     System.out.println(s + " String length> "+s.length());
    //     if(s.length() == 0) {
    //         System.out.println("First if of 0 length");
    //         return -1;
    //     }
        
    //     if(s.length() == 1) {
    //         System.out.println("Second i fof 1 length");
    //         return 0;
    //     }

    //     for (int i = 0 ; i < s.length() ; i++){
    //         System.out.println("First for");
    //         for (int j = i+1 ; j < s.length(); j++ ){
    //             System.out.println("Second for ");
    //             if(s.charAt(i) == s.charAt(j)){

    //                 String newstr = s.substring(0,i)+  s.substring(i+1,j) + s.substring(j+1 , s.length());
    //                 // String newstr1 = newstr.replaceAll(" ", "");
    //                 System.out.println(newstr);
    //                 return firstUniqChar(newstr);
    //                 // System.out.println(newstr1);
    //                 // firstUniqChar(newstr1);
    //             }
    //             // else if (s.length() == 0) return -1;
    //             // else return i;
    //         }
    //         return indexofchar(s.charAt(i));
    //     }

    //     return 0;
    // }

    public static int firstUniqChar(String s) {
        if (s.length() == 0) return -1;

        if (s.length() == 1) return 0;

        for (int i = 0 ; i< s.length() ; i++){
            for (int j = 0 ; j< s.length() ; j++){
                if(s.charAt(i) == s.charAt(j) && i!=j) break;
                else if (j == s.length()-1 && s.charAt(i) != s.charAt(j)) return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // String s = "loveleetcode";
        // String s = "aabb";
        // String s = "z";
        String s = "dddccdbba";
        // String s = "leetcode";

        System.out.println(firstUniqChar(s));
    }
}


// 171. Excel Sheet Column Number
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

// For example:

// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...
 

// Example 1:

// Input: columnTitle = "A"
// Output: 1
// Example 2:

// Input: columnTitle = "AB"
// Output: 28
// Example 3:

// Input: columnTitle = "ZY"
// Output: 701
 

// Constraints:

// 1 <= columnTitle.length <= 7
// columnTitle consists only of uppercase English letters.
// columnTitle is in the range ["A", "FXSHRXW"].

import java.util.*;
class Solution {
    public int titleToNumber(String s) {
        // if(s.equals("FXSHRXW")) return Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(ch, ch - 'A' + 1);
        }
        if(s.length() == 1) {
            return map.get(s.charAt(0));
        }
        int res = 0;
        // int j = 0;
        for (int i = 0 ; i < s.length() ;i++) {
            // res+= (long)(map.get(s.charAt(i-1)) * 26) + map.get(s.charAt(i));
            // j++;
            res = res * 26 + map.get(s.charAt(i));
        }
        return res;
    }
}
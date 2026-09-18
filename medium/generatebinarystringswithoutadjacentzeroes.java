// 3211. Generate Binary Strings Without Adjacent Zeros
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a positive integer n.

// A binary string x is valid if all substrings of x of length 2 contain at least one "1".

// Return all valid strings with length n, in any order.

 

// Example 1:

// Input: n = 3

// Output: ["010","011","101","110","111"]

// Explanation:

// The valid strings of length 3 are: "010", "011", "101", "110", and "111".

// Example 2:

// Input: n = 1

// Output: ["0","1"]

// Explanation:

// The valid strings of length 1 are: "0" and "1".

 

// Constraints:

// 1 <= n <= 18
import java.util.*;
class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        bt(res, n, new StringBuilder());
        return res;
    }

    void bt(List<String> res, int n, StringBuilder s) {
        if (s.length() == n) {
            res.add(s.toString());
            return;
        }

        s.append('1');
        bt(res, n, s);
        s.deleteCharAt(s.length() - 1);

        if (s.length() == 0 || s.charAt(s.length() - 1) != '0') {
            s.append('0');
            bt(res, n, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
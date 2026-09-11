// 3483. Unique 3-Digit Even Numbers
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of digits called digits. Your task is to determine the number of distinct three-digit even numbers that can be formed using these digits.

// Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.

 

// Example 1:

// Input: digits = [1,2,3,4]

// Output: 12

// Explanation: The 12 distinct 3-digit even numbers that can be formed are 124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432. Note that 222 cannot be formed because there is only 1 copy of the digit 2.

// Example 2:

// Input: digits = [0,2,2]

// Output: 2

// Explanation: The only 3-digit even numbers that can be formed are 202 and 220. Note that the digit 2 can be used twice because it appears twice in the array.

// Example 3:

// Input: digits = [6,6,6]

// Output: 1

// Explanation: Only 666 can be formed.

// Example 4:

// Input: digits = [1,3,5]

// Output: 0

// Explanation: No even 3-digit numbers can be formed.

 

// Constraints:

// 3 <= digits.length <= 10
// 0 <= digits[i] <= 9

import java.util.*;

class Solution {
    public int totalNumbers(int[] d) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        int num = 0;
        for(int i = 0 ; i < d.length ; i++) {
            num = num*10 + d[i];
            for(int j = 0 ; j < d.length ; j++) {
                if(j == i) continue;
                num = num*10 + d[j];
                for(int k = 0 ; k < d.length ; k++) {
                    if(k == i || k == j) continue;
                    num = num*10 + d[k];
                    if(num > 99 && num < 1000 && num%2 == 0 && !set.contains(num)) {
                        count++;
                        set.add(num);
                    }
                    num/=10;
                }
                num/=10;
            }
            num = 0;
        }
        return count;
    }
}
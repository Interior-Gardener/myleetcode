
// Easy
// Topics
// premium lock icon
// Companies
// You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

// Given the integer n, return the number of complete rows of the staircase you will build.

 

// Example 1:


// Input: n = 5
// Output: 2
// Explanation: Because the 3rd row is incomplete, we return 2.
// Example 2:


// Input: n = 8
// Output: 3
// Explanation: Because the 4th row is incomplete, we return 3.
 

// Constraints:

// 1 <= n <= 231 - 1

class Solution {
    public static int arrangeCoins(int n) {

        int rows = 0;
        int i = 1;
        // boolean neg = false;
        while(n>0){
            // System.out.println("val>"+(n-=i));
            n-=i;
            if(n<0) break;
            i++;
            rows++;
        }

        // if(neg) return rows-1;
        return rows;
    }

    public static void main (String[] args){
        int n = 3; 

        System.out.println(arrangeCoins(n));
    }
}
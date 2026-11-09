// Minimum Coins of 1, 2, 5 and 10
// Solved
// Difficulty: EasyAccuracy: 51.25%Submissions: 123K+Points: 2
// Given an integer n representing a target value and an infinite supply of coins of denominations 1, 2, 5, and 10, find the minimum number of coins required to make the value n.

// Examples:

// Input: n = 39
// Output: 6
// Explanation: 39 can be formed using 3 coins of 10 rupees, 1 coin of 5 rupees and 2 coins of 2 rupees so minimum coins required are 6.
// Input: n = 121
// Output: 13
// Explanation: 121 can be formed using 12 coins of 10 rupees and 1 coin of 1 rupees.
// Constraints:

// 1 ≤ n ≤ 106

class Solution {
    public int findMin(int n) {
        // code here
        // 1 2 5 10
        int res = 0;
        int sum = 0;
        while(sum + 10 <= n) {
            res++;
            sum+=10;
        }
        
        while(sum + 5 <= n) {
            res++;
            sum+=5;
        }
        
        while(sum + 2 <= n) {
            res++;
            sum+=2;
        }
        
        while(sum + 1 <= n) {
            res++;
            sum+=1;
        }
        
        return res;
    }
}

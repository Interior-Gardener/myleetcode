// 322. Coin Change
// Medium
// Topics
// premium lock icon
// Companies
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0
 

// Constraints:

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104

// class Solution {
//     int res = -1;
//     public int coinChange(int[] coins, int amount) {
//         // if(coins.length == 1) return 1;
//         if(amount == 0) return 0;
//         Arrays.sort(coins);
//         for (int i = 0; i < coins.length / 2; i++) {
//             int temp = coins[i];
//             coins[i] = coins[coins.length - 1 - i];
//             coins[coins.length - 1 - i] = temp;
//         }
        
//         return solve(coins , amount , 0);
//     }

//     int solve(int[] coins , int target , int curr) {
//         if(target == 0) {
//             if(res == -1 && curr > 0) {
//                 res = curr;
//             }
//             else {
//                 res = Math.min(res , curr);
//             }
//         }
//         for(int i = 0 ; i < coins.length ;i++) {
//             if(coins[i] > target) {
//                 continue;
//             }

//             solve(coins , target - coins[i] , curr+1);
//         }
//         return res;
//     }
// }

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Arrays.sort(coins);
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE || dp[amount] == Integer.MIN_VALUE)
            return -1;
        return dp[amount];
    }
}
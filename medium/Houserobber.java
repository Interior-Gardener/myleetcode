// 198. House Robber
// Attempted
// Medium
// Topics
// premium lock icon
// Companies
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0] , nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            int pick = dp[i - 2] + nums[i];
            int notpick = dp[i - 1];
            dp[i] = Math.max(pick, notpick);
        }
        // printArr(dp);
        return dp[dp.length - 1];
    }

    void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// class Solution {
//     class Pair{
//         int a;
//         int b;

//         public Pair(int a , int b) {
//             this.a = a;
//             this.b = b;
//         }
//     }
//     public int rob(int[] nums) {
//         if(nums.length == 1) return nums[0];
//         if(nums.length == 2) return Math.max(nums[0] , nums[1]);
//         Pair[] dp = new Pair[nums.length];
//         for(int i = 0 ; i < nums.length ;i++) {
//             dp[i] = new Pair(0,0);
//         }
//         dp[0] = new Pair(nums[0] , 0);
//         dp[1] = new Pair(nums[1] , 1);

//         for(int i = 3 ; i < nums.length ; i++) {
//             int a = dp[i-2].a + nums[i];
//             int b = Math.max
//         }


//         // int[] dp = new int[nums.length];
//         // dp[0] = nums[0];
//         // dp[1] = nums[1];
//         // int globalmax = Math.max(dp[0], dp[1]);
//         // for (int i = 2; i < nums.length; i++) {
//         //     int picked = 0;
//         //     if (globalmax != dp[i - 1]) {
//         //         picked = globalmax + nums[i];
//         //     } else {
//         //         picked = dp[i - 2] + nums[i];
//         //     }
//         //     int notpicked = dp[i - 1];
//         //     dp[i] = Math.max(picked, notpicked);
//         //     globalmax = Math.max(globalmax, dp[i]);
//         // }
//         // printArr(dp);
//         // return dp[dp.length - 1];
//     }

//     static void printArr(int[] arr) {
//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//         System.out.println();
//     }
// }
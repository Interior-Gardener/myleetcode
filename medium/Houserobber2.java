// 213. House Robber II
// Attempted
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
// Example 2:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 3:

// Input: nums = [1,2,3]
// Output: 3
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        // if(nums.length == 3) return Math.max(nums[0] , Math.max( nums[1] , nums[2]));

        int[] arr2 = new int[nums.length - 1];
        for(int i = 0 ; i < arr2.length ;i++) {
            arr2[i] = nums[i];
        }

        int first = rob1(arr2);

        int[] arr1 = new int[nums.length - 1];
        for(int i = 0 ; i < arr1.length ;i++) {
            arr1[i] = nums[i+1];
        }

        int second = rob1(arr1);

        return Math.max(first,second);
    }

    int rob1(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        for(int i = 2 ; i < nums.length ; i++) {
            int pick = dp[i-2] + nums[i];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[nums.length - 1];
    }
}
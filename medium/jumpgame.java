// 55. Jump Game
// Medium
// Topics
// premium lock icon
// Companies
// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

// Constraints:

// 1 <= nums.length <= 104
// 0 <= nums[i] <= 105

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        // int space = 0;
        // for(int i = nums.length - 1 ;i >= 0 ;i--) {
        //     if(nums[i] == 0) {
        //         space++;
        //     }
        //     else break;
        // }
        // if(space == nums.length) return false;
        // int i;
        // for (i = 0; i < nums.length - space; i++)
        //     if (nums[i] == 0 && i != nums.length - 1)
        //         return false;
        // if(nums[i-1] == space) return true;
        // return true;
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0 && i != nums.length - 1) {
        //         // System.out.println("here");
        //         return false;
        //     }
        //     sum += nums[i];
        //     if (sum >= nums.length - 1) {
        //         return true;
        //     }
        //     if (nums[i + nums[i]] == 0) {
        //         sum -= nums[i];
        //     }
        //     if (nums[i + nums[i]] != 0) {
        //         i += nums[i]-1;
        //     }
        // }
        // return true;

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0 ; i < nums.length ;i++) {
            // if(!dp[i]) {
                for(int j = i+1 ; j < nums.length && nums[i] > 0; j++) {
                    dp[j] = true;
                    nums[i]--;
                }
            // }
        }
        for(boolean i : dp) {
            if(!i) return false;
        }
        return true;
    }
}
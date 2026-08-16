// 3702. Longest Subsequence With Non-Zero Bitwise XOR
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array nums.

// Return the length of the longest subsequence in nums whose bitwise XOR is non-zero. If no such subsequence exists, return 0.

 

// Example 1:

// Input: nums = [1,2,3]

// Output: 2

// Explanation:

// One longest subsequence is [2, 3]. The bitwise XOR is computed as 2 XOR 3 = 1, which is non-zero.

// Example 2:

// Input: nums = [2,3,4]

// Output: 3

// Explanation:

// The longest subsequence is [2, 3, 4]. The bitwise XOR is computed as 2 XOR 3 XOR 4 = 5, which is non-zero.

 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109

class Solution {
    public int longestSubsequence(int[] nums) {
        boolean allzero = true;
        for(int i : nums) {
            if(i != 0) allzero = false;
        }
        if(allzero) return 0;
        int ans = nums[0];
        for(int i = 1 ; i <nums.length ;i++) {
            ans = ans^nums[i];
        }
        if(ans != 0) return nums.length;
        else return nums.length-1;
    }
}

// 628. Maximum Product of Three Numbers
// Attempted
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: 6
// Example 2:

// Input: nums = [1,2,3,4]
// Output: 24
// Example 3:

// Input: nums = [-1,-2,-3]
// Output: -6
 

// Constraints:

// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000

class Solution {
    public int maximumProduct(int[] nums) {
        int firstmax = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
        int thirdmax = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        int seclowest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstmax) {
                thirdmax = secondmax;
                secondmax = firstmax;
                firstmax = nums[i];
                // continue;
            } else if (nums[i] > secondmax) {
                thirdmax = secondmax;
                secondmax = nums[i];
                // continue;
            } else if (nums[i] > thirdmax) {
                thirdmax = nums[i];
                // continue;
            }
            
            if(nums[i] < lowest) {
                seclowest = lowest;
                lowest = nums[i];
            }
            else if(nums[i] < seclowest) {
                seclowest = nums[i];
            }
        }
        return Math.max(firstmax * secondmax * thirdmax, firstmax * lowest * seclowest);
    }
}
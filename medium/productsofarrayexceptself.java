// 238. Product of Array Except Self
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// Constraints:

// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

// Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        // for (int i = 0; i < nums.length; i++) {
        // int temp = 1;
        // for (int j = 0; j < nums.length; j++) {
        // if (i == j)
        // continue;
        // temp = temp * nums[j];
        // }
        // result[i] = temp;
        // }
        // return result;
        // result[0] = nums[0];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        // printArr(result);
        // result[nums.length-2] *= nums[nums.length-1];
        // nums[nums.length -2] = nums[nums.length -2] * nums[nums.length - 1];
        // for (int i = nums.length - 2; i >= 0; i--) {
        // result[i] = nums[i + 1] * result[i];
        // if (i == nums.length - 2) {
        // nums[nums.length - 2] = nums[nums.length - 1];
        // continue;
        // }
        // nums[i] = nums[i+1] * nums[i + 2];
        // System.out.println("nums");
        // printArr(nums);
        // }

        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 4, 5 };
        // prefix = { 1, 3, 6, 10, };
        // left = { 1 1 2 6 24 }
        // O/P = {120 60 40 30 24}
        // int[] nums = { -1, 1, 0, -3, 3 };
        int[] nums = { 4, 3, 2, 1, 2 };

        printArr(productExceptSelf(nums));
    }

    public static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
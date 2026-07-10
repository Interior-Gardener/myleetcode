// 503. Next Greater Element II
// Medium
// Topics
// premium lock icon
// Companies
// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

// Example 1:

// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.
// Example 2:

// Input: nums = [1,2,3,4,3]
// Output: [2,3,4,-1,4]

// Constraints:

// 1 <= nums.length <= 104
// -109 <= nums[i] <= 109

// public static int[] nextGreaterElements(int[] nums) {
//     int[] ans = new int[nums.length];
//     // int temp = -1;
//     for (int i = 0; i < ans.length; i++) {
//         int j = i - 1;
//         if (j < 0)
//             j = ans.length - 1;
//         Stack<Integer> s = new Stack<>();
//         while (j != i) {
//             while (s.size() > 0 && nums[i] <= s.peek()) {
//                 s.pop();
//             }
//             s.push(nums[j]);
//             ans[i] = s.empty() ? -1 : s.peek();
//             System.out.println(s + " " + "j>" + j);
//             j--;
//             if (j < 0)
//                 j = ans.length - 1;
//         }
//     }
//     return ans;
// }

import java.util.*;

class Solution {
    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        // for (int i = 0; i < nums.length - 1; i++) {
        for (int i = nums.length - 1; i >= 0; i--) {
            s.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (s.size() > 0 && nums[i] >= s.peek()) {
                s.pop();
            }
            ans[i] = s.empty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[] nums = { 5,4,3,2,1 };
        int[] nums = { -3,-2,-1 };
        // int[] nums = { 1, 2, 3, 4, 3 };
        printArray(nextGreaterElements(nums));
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}

// 31. Next Permutation
// Medium
// Topics
// premium lock icon
// Companies
// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.

// Example 1:

// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:

// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:

// Input: nums = [1,1,5]
// Output: [1,5,1]

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        if(nums.length == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }

        boolean desc = true;
        for(int i = 1 ; i < nums.length ;i++) {
            if(nums[i] > nums[i-1]) {
                desc = false;
            }
        }
        if(desc) {
            Arrays.sort(nums);
            return;
        }
        // 1 2 5 4 3  -- 1 3 2 4 5
        for(int i = 1 ; i < nums.length ;i++) {
            if(nums[i-1] > nums[i]) {
                int k = nums[i-1];
                for(int j = i ; j < nums.length ;j++) {

                }
            }
        }

    }

    public static void swap(int nums[],int a , int b) {

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
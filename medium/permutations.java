// 46. Permutations
// Medium
// Topics
// premium lock icon
// Companies
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]
 

// Constraints:

// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.


import java.util.*;

class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        getpermutations(nums, 0, list);

        return list;
    }

    public static void getpermutations(int[] nums, int index, List<List<Integer>> list) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }
            list.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums,index,i);
            getpermutations(nums, index + 1, list);

            swap(nums,index,i);
        }
        // return;
    }

    public static void swap(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        // return;
    }
}

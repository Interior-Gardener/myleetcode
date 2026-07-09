// 540. Single Element in a Sorted Array
// Medium
// Topics
// premium lock icon
// Companies
// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: nums = [3,3,7,7,10,11,11]
// Output: 10

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105

// class Solution {
//     public int singleNonDuplicate(int[] nums) {
// O(n) time complexity we want O(logn) only binary search gives logn time
// complexity
// if(nums.length == 1) return nums[0];
// for(int i = 1 ; i < nums.length; i++){
// if(i == nums.length -1) return nums[i];
// // int j=i-1;
// if(nums[i-1]!=nums[i] && nums[i] != nums[i+1]) return nums[i];
// }
// return -1;

// Still its O(n/2) or O(n) not O(logn)
// if (nums.length == 1)
//     return nums[0];

// int i = 1, j = nums.length - 2;
// int icount = 0, jcount = 0;

// while (i <= j) {
//     if (nums[i] != nums[i - 1])
//         icount++;
//     if (nums[i] == nums[i - 1])
//         icount = 0;
//     if (nums[j] != nums[j + 1])
//         jcount++;
//     if (nums[j] == nums[j + 1])
//         jcount = 0;
//     if (jcount == 2)
//         return nums[j + 1];
//     if (icount == 2)
//         return nums[i - 1];
//     i++;
//     j--;

// }
// return -1;

// Still O(n) how do i implement binary search?
// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         if (nums.length == 1)
//             return nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             if (i == nums.length - 1)
//                 return nums[i];
//             if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1])
//                 return nums[i];
//         }
//         return -1;
//     }
// }

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        return BS(nums, 0, nums.length - 1);
    }

    public int BS(int[] nums, int low, int high) {
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length -1] != nums[nums.length -2]) return nums[nums.length -1];
        // if((high - low) < 3) {
        //     if((low - 1) < 0) {
        //         return nums[low];
        //     }
        //     if()
        // } 
        int mid = low + (high-low)/2;
        while(low<=high) {
            if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]) return nums[mid];
            else if(nums[mid] == nums[mid-1]) {
                if(mid%2 == 0) {
                    return BS(nums,low,mid);
                }
                else {
                    return BS(nums,mid+1,high);
                }
            }
            else{
                if(mid%2 == 0) {
                    return BS(nums,mid,high);
                }
                else {
                    return BS(nums,low,mid-1);
                }
            }
        }
        return -1;
    }
}
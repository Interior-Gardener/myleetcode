// Code
// 2091. Removing Minimum and Maximum From Array
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a 0-indexed array of distinct integers nums.

// There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.

// A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.

// Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.

 

// Example 1:

// Input: nums = [2,10,7,5,4,1,8,6]
// Output: 5
// Explanation: 
// The minimum element in the array is nums[5], which is 1.
// The maximum element in the array is nums[1], which is 10.
// We can remove both the minimum and maximum by removing 2 elements from the front and 3 elements from the back.
// This results in 2 + 3 = 5 deletions, which is the minimum number possible.
// Example 2:

// Input: nums = [0,-4,19,1,8,-2,-3,5]
// Output: 3
// Explanation: 
// The minimum element in the array is nums[1], which is -4.
// The maximum element in the array is nums[2], which is 19.
// We can remove both the minimum and maximum by removing 3 elements from the front.
// This results in only 3 deletions, which is the minimum number possible.
// Example 3:

// Input: nums = [101]
// Output: 1
// Explanation:  
// There is only one element in the array, which makes it both the minimum and maximum element.
// We can remove it with 1 deletion.
 

// Constraints:

// 1 <= nums.length <= 105
// -105 <= nums[i] <= 105
// The integers in nums are distinct.

class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minidx = -1, maxidx = -1;
        int n = nums.length;
        int deletions = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minidx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxidx = i;
            }
        }
        int a = Math.min(minidx, maxidx);
        // int d1 = a+1;
        // int d2 = n - a;
        // if(d2 < d1) {
        //     return d2;
        // }
        // deletions += d1;

        int b = Math.max(minidx, maxidx);
        // int d3 = b+1;
        // int d4 = n - b;
        // deletions = Math.min(d1 + Math.min(d3,d4) , d3);
        // if(deletions == d3){
        //     return d3;
        // }

        // deletions = Math.min(deletions , Math.min(d3,d2));
        // return deletions;

        int d1 = b + 1;
        int d2 = n - a;
        int d3 = (a + 1) + (n - b);

        return Math.min(d1, Math.min(d2, d3));

        // int deletions = 0;
        // int start = Math.min(minidx , maxidx);
        // int m = Math.min(start+1, n - start);
        // deletions += m;
        // int distend = n - start;
        // if(Math.max(minidx,maxidx) > start && m == distend) {
        //     return deletions;
        // }
        // int end = Math.max(minidx , maxidx);
        // end = Math.min(n - end , end - deletions + 1);
        // deletions += end;
        // return deletions;
    }
}
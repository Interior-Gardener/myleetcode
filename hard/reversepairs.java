// 493. Reverse Pairs
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].

// Example 1:

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
// Example 2:

// Input: nums = [2,4,3,5,1]
// Output: 3
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
// (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1

// Constraints:

// 1 <= nums.length <= 5 * 104
// -231 <= nums[i] <= 231 - 1

import java.util.*;

class Solution {
    int res = 0;

    public int reversePairs(int[] nums) {
        // int[] sorted = nums.clone();
        // Arrays.sort(sorted);

        // for (int i = 0, j = sorted.length - 1; i < j; i++, j--) {
        // int temp = sorted[i];
        // sorted[i] = sorted[j];
        // sorted[j] = temp;
        // }

        // if (Arrays.equals(nums, sorted)) {
        // return nums.length - 1;
        // }

        mergesort(nums, 0, nums.length - 1);
        return res;
    }

    public void merge(int[] nums, int start, int mid, int end) {
        // First count pairs
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && (long) nums[i] > 2L * nums[j])
                j++;

            res += (j - mid - 1);
        }

        // now merge
        ArrayList<Integer> temp = new ArrayList<>();

        int i = start;
        j = mid + 1;

        while (i <= mid && j <= end) {
            // if (nums[i] > (2 * nums[j])) {
            // res += (mid - i + 1);
            // int k = i;
            // while (k >= 0 && nums[k] > (2 * nums[j]))
            // k--;
            // res += (i - k);
            // res += (mid - i);
            // }

            if (nums[i] <= nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }

        while (j <= end) {
            temp.add(nums[j]);
            j++;
        }

        while (i <= mid) {
            temp.add(nums[i]);
            i++;
        }

        for (int index = 0; index < temp.size(); index++) {
            nums[start + index] = temp.get(index);
        }
    }

    public void mergesort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            // System.out.println("Here");
            mergesort(nums, start, mid);
            mergesort(nums, mid + 1, end);

            merge(nums, start, mid, end);
        }
    }
}
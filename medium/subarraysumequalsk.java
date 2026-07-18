// 560. Subarray Sum Equals K
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2

// Constraints:

// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
import java.util.*;

class Solution {
    // public int subarraySum(int[] nums, int k) {
    // int count = 0;
    // for (int i = 0 ; i < nums.length ; i++) {
    // for(int j = i ; j < nums.length ; j++) {
    // int sum = 0;
    // for( int l = i ; l <=j ; l++) {
    // sum+= nums[l];
    // }
    // if(sum == k) {
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    // public static int subbarraySum(int[] nums , int k) {
    // Arrays.sort(nums);
    // int i = 0;
    // int j = i;
    // int count = 0;
    // while(i<nums.length && j< nums.length) {
    // int sum=0;
    // for(int a = i ; a<=j ; a++){
    // sum+=nums[a];
    // }
    // if(sum == k) {
    // count++;
    // i++;
    // j++;
    // }
    // else if(sum < k) {
    // j++;
    // }
    // else{
    // i++;
    // }
    // }
    // return count;
    // }

    // public static int subarraySum(int[] nums, int k) {
    // int count = 0;
    // HashSet<Integer> set = new HashSet<>();
    // int[] prefix = new int[nums.length];
    // int temp = nums[0];
    // prefix[0] = temp;
    // for (int i = 1; i < nums.length; i++) {
    // temp += nums[i];
    // prefix[i] = temp;
    // }

    // for (int i = 0; i < prefix.length; i++) {
    // int complement = prefix[i] - k;
    // if(prefix[i] == k) {
    // count++;
    // set.add(prefix[i]);
    // }

    // if(set.contains(complement) ) {
    // count++;
    // set.add(prefix[i]);
    // }
    // set.add(prefix[i]);
    // }
    // return count;
    // }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < prefix.length; i++) {
            int complement = prefix[i] - k;

            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // int[] nums = { -1, 2, 5, -2, 4 };
        // prefix = {-1 , 1 , 6 , 4 , 8}
        // prefix = {-1 , 1 , 5 , 9 , 7}
        // int k = 2;
        // int[] nums = {1,1,1};
        // prefix = {1 , 2 , 3}
        // int k = 2;
        // int[] nums = {0,0,0,0};
        // int[] nums = {1,0,-1};
        // int[] nums = {1,-1,0,0,-1,1};
        int[] nums = { 1, -1, 0 };
        // prefix = {1,0,0}
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
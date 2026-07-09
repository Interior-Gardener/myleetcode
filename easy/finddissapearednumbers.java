// 448. Find All Numbers Disappeared in an Array
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

// Example 1:

// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]
// Example 2:

// Input: nums = [1,1]
// Output: [2]
 

// Constraints:

// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
import java.util.*;
class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        List<Integer> result  =  new ArrayList<>();

        for(int i = 0 ; i< n ; i++){
            list.add(0);
            // System.out.println(list);
        }

        for(int  i = 0 ; i < n ; i++){
            // System.out.println(list.get(nums[i]-1)+1);
            list.set(nums[i]-1,list.get(nums[i]-1)+1);
            // System.out.println(list);
            
        }

        for(int i = 0 ; i <list.size(); i++){
            if(list.get(i) == 0) result.add(i+1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(nums));
    }
}
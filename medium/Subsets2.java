// 90. Subsets II
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10

import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums,result,set,0,new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums , List<List<Integer>> result ,  HashSet<ArrayList<Integer>> set,int index ,ArrayList<Integer> temp) {

        if(!set.contains(temp)) {
            set.add(temp);
            ArrayList<Integer> add = new ArrayList<>(temp);
            result.add(add);
        }

        if(temp.size() == nums.length) {
            return;
        }

        for(int i = index ; i < nums.length ; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            index = i + 1;
            backtrack(nums,result,set,index,temp);
            index--;
            temp.remove(temp.size()-1);
        }
    }
}
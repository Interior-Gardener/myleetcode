// 47. Permutations II
// Medium
// Topics
// premium lock icon
// Companies
// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

// Example 1:

// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
// Example 2:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

// Constraints:

// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
import java.util.*;
class Solution {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        getpermutations(nums, 0, list,set);
        for(List<Integer> s : set) {
            list.add(s);
        }
        return list;
    }

    public static void getpermutations(int[] nums, int index, List<List<Integer>> list,HashSet<List<Integer>> set) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }
            // list.add(temp);
            set.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums,index, i);
            getpermutations(nums, index + 1, list,set);

            swap(nums,index, i);
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
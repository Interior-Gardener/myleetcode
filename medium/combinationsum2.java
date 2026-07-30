// 40. Combination Sum II
// Medium
// Topics
// premium lock icon
// Companies
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]

// Constraints:

// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, arr, target, new ArrayList<Integer>(), 0, new HashSet<ArrayList<Integer>>());
        return result;
    }

    public void helper(List<List<Integer>> result, int[] arr, int target, ArrayList<Integer> subset, int index,
            HashSet<ArrayList<Integer>> set) {
        if (sumofsubset(subset) > target) {
            return;
        }

        if (sumofsubset(subset) == target) {
            ArrayList<Integer> temp = new ArrayList<>(subset);
            // temp.sort(null);
            // if (set.contains(temp)) {
            // return;
            // } else {
            result.add(temp);
            // set.add(temp);
            return;
            // }
        }

        for (int i = index; i < arr.length; i++) {
            subset.add(arr[i]);
            ArrayList<Integer> temp = new ArrayList<>(subset);
            temp.sort(null);
            if (set.contains(temp)) {
                subset.removeLast();
                continue;
            } else {
                set.add(temp);
                helper(result, arr, target, subset, i + 1, set);
                subset.removeLast();
            }
        }
    }

    public int sumofsubset(ArrayList<Integer> arr) {
        int sum = 0;
        for (Integer i : arr) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        // int[] arr = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        // int target = 27;

        System.out.println(sol.combinationSum2(arr, target));
    }
}
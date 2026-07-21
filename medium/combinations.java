// 77. Combinations
// Medium
// Topics
// premium lock icon
// Companies
// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

// Example 1:

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
// Example 2:

// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.

// Constraints:

// 1 <= n <= 20
// 1 <= k <= n77. Combinations
// Medium
// Topics
// premium lock icon
// Companies
// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

// Example 1:

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
// Example 2:

// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.

// Constraints:

// 1 <= n <= 20
// 1 <= k <= n
import java.util.*;

class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, result, new ArrayList<>(), 1);
        return result;
    }

    public static void backtrack(int n, int k, List<List<Integer>> result, ArrayList<Integer> temp, int start) {

        if (temp.size() == k) {
            ArrayList<Integer> temp1 = new ArrayList<>(temp);
            result.add(temp1);
            return;
        }

        for (int i = start; i <= n; i++) {
            // if (!temp.isEmpty()) {
            //     if (i <= temp.getLast())
            //         continue;
            // }
            temp.add(i);
            backtrack(n, k, result, temp,i+1);
            temp.removeLast();
        }

    }
}
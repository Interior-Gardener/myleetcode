// 506. Relative Ranks
// Easy
// Topics
// premium lock icon
// Companies
// You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

// The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

// The 1st place athlete's rank is "Gold Medal".
// The 2nd place athlete's rank is "Silver Medal".
// The 3rd place athlete's rank is "Bronze Medal".
// For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
// Return an array answer of size n where answer[i] is the rank of the ith athlete.

 

// Example 1:

// Input: score = [5,4,3,2,1]
// Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
// Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
// Example 2:

// Input: score = [10,3,8,9,4]
// Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
// Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

 

// Constraints:

// n == score.length
// 1 <= n <= 104
// 0 <= score[i] <= 106
// All the values in score are unique.

import java.util.*;
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] ans = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i : nums) {
            q.add(i);
        }

        int count = 1;

        while (!q.isEmpty()) {
            if (count == 1) {
                ans[map.get(q.poll())] = "Gold Medal";
                count++;
                continue;
            }
            if (count == 2) {
                ans[map.get(q.poll())] = "Silver Medal";
                count++;
                continue;
            }
            if (count == 3) {
                ans[map.get(q.poll())] = "Bronze Medal";
                count++;
                continue;
            }
            ans[map.get(q.poll())] = Integer.toString(count);
            count++;
        }
        return ans;
    }
}

// class Solution {
//     public String[] findRelativeRanks(int[] nums) {
//         int n = nums.length;
//         String[] ans = new String[n];
//         if (n == 1) {
//             ans[0] = "Gold Medal";
//             return ans;
//         }
//         if (n == 2) {
//             if (nums[0] > nums[1]) {
//                 ans[0] = "Gold Medal";
//                 ans[1] = "Silver Medal";
//                 return ans;
//             }
//         }
//         if (n == 3) {
//             if (nums[0] > nums[1] && nums[0] > nums[2]) {
//                 if (nums[1] > nums[2]) {
//                     ans[0] = "Gold Medal";
//                     ans[1] = "Silver Medal";
//                     ans[2] = "Bronze Medal";
//                     return ans;
//                 }
//                 else {
//                     ans[0] = "Gold Medal";
//                     ans[2] = "Silver Medal";
//                     ans[1] = "Bronze Medal";
//                     return ans;
//                 }
//             }
//             else if(nums[1] > nums[2]) {
//                 if(nums[0] > nums[2]) {
//                     ans[1] = "Gold Medal";
//                     ans[0] = "Silver Medal";
//                     ans[2] = "Bronze Medal";
//                     return ans;
//                 }
//                 else{
//                     ans[1] = "Gold Medal";
//                     ans[2] = "Silver Medal";
//                     ans[0] = "Bronze Medal";
//                     return ans;
//                 }
//             }
//             else{
//                 if(nums[0] > nums[1]) {
//                     ans[2] = "Gold Medal";
//                     ans[0] = "Silver Medal";
//                     ans[1] = "Bronze Medal";
//                     return ans;
//                 }
//                 else{
//                     ans[2] = "Gold Medal";
//                     ans[1] = "Silver Medal";
//                     ans[0] = "Bronze Medal";
//                     return ans;
//                 }
//             }
//         }

//         PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
//         for(int i : nums) {
//             q.add(i);
//         }

//         for(int i = 0 ; i < n ; i++) {
//             if(nums[i] == q.peek()){
//                 ans[i] = "Gold Medal";
//             }
//             else{
//                 ans[i] = Integer.toString(nums[i]);
//             }
//         }
//         q.poll();
//         for(int i = 0 ; i < n ; i++) {
//             if(nums[i] == q.peek()){
//                 ans[i] = "Silver Medal";
//             }
//             else if(ans[i] != "Gold Medal"){
//                 ans[i] = Integer.toString(nums[i]);
//             }
//         }
//         q.poll();
//         for(int i = 0 ; i < n ; i++) {
//             if(nums[i] == q.peek()){
//                 ans[i] = "Bronze Medal";
//             }
//             else if (ans[i] != "Gold Medal" && ans[i] != "Silver Medal"){
//                 ans[i] = Integer.toString(nums[i]);
//             }
//         }
//         return ans;
//     }
// }

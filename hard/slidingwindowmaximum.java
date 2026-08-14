// 239. Sliding Window Maximum
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length


// import java.util.*;
// class Solution {
//     private class Pair {
//         int value;
//         int index;
//         Pair(int value, int index) {
//             this.value = value;
//             this.index = index;
//         }
//     }

//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int[] arr = new int[nums.length - k + 1];
//         PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> b.value - a.value);

//         for (int i = 0; i < k; i++) {
//             heap.offer(new Pair(nums[i], i));
//         }
//         arr[0] = heap.peek().value;
//         int index = 1;
//         for (int i = k; i < nums.length; i++) {
//             heap.offer(new Pair(nums[i], i));
//             while (heap.peek().index < i - k + 1) {
//                 heap.poll();
//             }
//             arr[index] = heap.peek().value;
//             index++;
//         }
//         return arr;
//     }
// }



import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {

            if (q.size() > 0 && nums[q.peekLast()] < nums[i]) {
                while (q.size() > 0 && nums[q.peekLast()] < nums[i])
                    q.pollLast();
            }
            q.offerLast(i);
        }
        list.add(nums[q.peekFirst()]);
        int i = 1, j = k;
        while (j < nums.length) {
            // curr window part?
            if (q.size() > 0 && q.peekFirst() < i)
                q.pollFirst();
            // less than new element ?
            if (q.size() > 0 && nums[q.peekLast()] < nums[j]) {
                while (q.size() > 0 && nums[q.peekLast()] < nums[j])
                    q.pollLast();
            }
            q.offerLast(j);
            list.add(nums[q.peekFirst()]);
            i++;
            j++;
        }

        int[] arr = new int[list.size()];
        for (int a = 0; a < arr.length; a++)
            arr[a] = list.get(a);
        return arr;
    }
}
// 632. Smallest Range Covering Elements from K Lists
// Hard
// Topics
// premium lock icon
// Companies
// You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

// We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

 

// Example 1:

// Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
// Output: [20,24]
// Explanation: 
// List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
// List 2: [0, 9, 12, 20], 20 is in range [20,24].
// List 3: [5, 18, 22, 30], 22 is in range [20,24].
// Example 2:

// Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
// Output: [1,1]
 

// Constraints:

// nums.length == k
// 1 <= k <= 3500
// 1 <= nums[i].length <= 50
// -105 <= nums[i][j] <= 105
// nums[i] is sorted in non-decreasing order.

// class Solution {
//     public int[] smallestRange(List<List<Integer>> nums) {
//         int k = nums.size();
//         PriorityQueue<List<Integer>> asc = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
//         PriorityQueue<List<Integer>> desc = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0));

//         HashMap<Integer, Integer> map = new HashMap<>();
//         HashSet<List<Integer>> active = new HashSet<>();

//         for (int i = 0; i < nums.size(); i++) {
//             asc.offer(nums.get(i));
//             desc.offer(nums.get(i));
//             active.add(nums.get(i));
//         }

//         int[] res = new int[2];
//         // res[0] = asc.peek().get(0);
//         // res[1] = desc.peek().get(1);
//         // map.put(asc.peek().get(0) , desc.peek().get(0));
//         while (!asc.isEmpty()) {
//             while (!desc.isEmpty() && !active.contains(desc.peek())) {
//                 desc.poll();
//             }
//             // Iterator<List<Integer>> it = pq.iterator();
//             res[0] = asc.peek().get(0);
//             res[1] = desc.peek().get(0);
//             // System.out.println(res[0] + " res " + res[1]);
//             if (!map.containsKey(res[0])) {
//                 map.put(res[0], res[1]);
//             } else if (map.containsKey(res[0]) && map.get(res[0]) - res[0] > res[1] - res[0]) {
//                 map.put(res[0], res[1]);
//             }

//             List<Integer> temp = new ArrayList<>();
//             temp = asc.poll();
//             active.remove(temp);

//             // desc.remove(temp);
//             temp.remove(0);

//             if (temp.isEmpty())
//                 break;

//             active.add(temp);
//             asc.add(temp);
//             desc.add(temp);

//         }

//         // int[] temp = new int[2];
//         // System.out.println(map + "<-- map");
//         for (Integer i : map.keySet()) {
//             if (((map.get(i) - i) < (res[1] - res[0])) || (((map.get(i) - i) == (res[1] - res[0])) && i < res[0])) {
//                 res[0] = i;
//                 res[1] = map.get(i);
//             }
//         }

//         return res;
//     }
// }


import java.util.*;
class Solution { 
    public int[] smallestRange(List<List<Integer>> nums) { 
        int k = nums.size(); 
        PriorityQueue<List<Integer>> asc = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0)); 
        PriorityQueue<List<Integer>> desc = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0)); 
 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        HashSet<List<Integer>> active = new HashSet<>(); 
 
        for (int i = 0; i < nums.size(); i++) { 
            // bc idhar bhi issue hai naya list banake pass krna padega pass by refernce ki aisi ki taisi meri jindagi ke 6 ghante khatam ho chuke hai
            List<Integer> a = new ArrayList<>(nums.get(i));
            List<Integer> b = new ArrayList<>(nums.get(i));

            asc.offer(a); 
            desc.offer(b); 
            active.add(a); 
        } 
 
        int[] res = new int[2]; 
        // res[0] = asc.peek().get(0); 
        // res[1] = desc.peek().get(1); 
        // map.put(asc.peek().get(0) , desc.peek().get(0)); 
        while (!asc.isEmpty()) { 
            while (!desc.isEmpty() && !active.contains(desc.peek())) { 
                desc.poll(); 
            } 
            // Iterator<List<Integer>> it = pq.iterator(); 
            res[0] = asc.peek().get(0); 
            res[1] = desc.peek().get(0); 
            // System.out.println(res[0] + " res " + res[1]); 
            if (!map.containsKey(res[0])) { 
                map.put(res[0], res[1]); 
            } else if (map.containsKey(res[0]) && map.get(res[0]) - res[0] > res[1] - res[0]) { 
                map.put(res[0], res[1]); 
            } 
 
            List<Integer> temp = new ArrayList<>(); 
            temp = asc.poll(); 
            active.remove(temp); 
 
            // desc.remove(temp); 
            temp.remove(0); 
 
            if (temp.isEmpty()) 
                break; 
 
            active.add(temp); 
            asc.add(temp); 
            desc.add(new ArrayList<>(temp)); 
 
        } 
 
        // int[] temp = new int[2]; 
        // System.out.println(map + "<-- map"); 
        for (Integer i : map.keySet()) { 
            if (((map.get(i) - i) < (res[1] - res[0])) || (((map.get(i) - i) == (res[1] - res[0])) && i < res[0])) { 
                res[0] = i; 
                res[1] = map.get(i); 
            } 
        } 
 
        return res; 
    } 
}
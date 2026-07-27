// 56. Merge Intervals
// Medium
// Topics
// premium lock icon
// Companies
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// Example 3:

// Input: intervals = [[4,7],[1,4]]
// Output: [[1,7]]
// Explanation: Intervals [1,4] and [4,7] are considered overlapping.

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
// import java.util.*;

// class Solution {
//     public int[][] merge(int[][] intervals) {
//         ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//         for (int[] nums : intervals) {
//             boolean added = false;
//             boolean remove = false;
//             boolean add = false;
//             ArrayList<Integer> temp1 = new ArrayList<>();
//             ArrayList<Integer> temp2 = new ArrayList<>();
//             for (ArrayList<Integer> list : result) {
//                 if ((nums[0] >= list.get(0) && nums[0] <= list.get(1))
//                         || (nums[1] >= list.get(0) && nums[1] <= list.get(1))
//                         || (nums[0] <= list.get(0) && nums[1] >= list.get(1))
//                         || (nums[0] >= list.get(0) && nums[1] <= list.get(1))) {
//                     temp2.add(Math.min(list.get(0), nums[0]));
//                     temp2.add(Math.max(list.get(1), nums[1]));
//                     // result.remove(list);
//                     remove = true;
//                     temp1 = list;
//                     // result.add(temp);
//                     add = true;
//                     added = true;
//                     continue;
//                 }
//                 // else if(nums[1] >= list.get(0) && nums[1] <= list.get(1)) {

//                 // }
//             }
//             if (!added) {
//                 ArrayList<Integer> temp = new ArrayList<>();
//                 temp.add(nums[0]);
//                 temp.add(nums[1]);
//                 result.add(temp);
//             }
//             if(remove) {
//                 result.remove(temp1);
//             }
//             if(add) {
//                 result.add(temp2);
//             }
//         }
//         int[][] finalResult = new int[result.size()][2];

//         for (int i = 0; i < result.size(); i++) {
//             finalResult[i][0] = result.get(i).get(0);
//             finalResult[i][1] = result.get(i).get(1);
//         }

//         return finalResult;
//     }
// }

class Solution {
  public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
          return intervals;
      }
      List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
      boolean mergedSomething = true; 
      while (mergedSomething) {
          mergedSomething = false;
          List<int[]> tempList = new ArrayList<>();
        
          while (!intervalList.isEmpty()) {
              int[] current = intervalList.remove(0);
              boolean isMerged = false;

              for (int i = 0; i < intervalList.size(); i++) {
                  int[] other = intervalList.get(i);

                  if (Math.max(current[0], other[0]) <= Math.min(current[1], other[1])) {
                      current = new int[]{Math.min(current[0], other[0]), Math.max(current[1], other[1])};
                      intervalList.remove(i); 
                      isMerged = true;
                      mergedSomething = true;
                      break;
                  }
              }
              tempList.add(current);
          }
          intervalList = tempList; 
      }
      return intervalList.toArray(new int[intervalList.size()][]);
  }
}
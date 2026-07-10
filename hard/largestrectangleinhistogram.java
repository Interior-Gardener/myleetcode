// 84. Largest Rectangle in Histogram
// Hard
// Topics
// premium lock icon
// Companies
// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:

// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
// Example 2:

// Input: heights = [2,4]
// Output: 4

// Constraints:

// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104

// class Solution {
//     public static int largestRectangleArea(int[] heights) {
//         if (heights.length == 1)
//             return heights[0];
//         if (heights.length == 2)
//             return Math.max(2 * Math.min(heights[0], heights[1]), Math.max(heights[0], heights[1]));

//         boolean onlyzeros = true;
//         for (int i = 0; i < heights.length - 1; i++) {
//             if (heights[i] != 0) {
//                 onlyzeros = false;
//                 break;
//             }
//         }
//         if (onlyzeros)
//             return 0;
//         int minht = Integer.MAX_VALUE;
//         int maxsum = Integer.MIN_VALUE;
//         int sum = -1;
//         // int[] arr = new int[heights.length];
//         for (int i = 0; i < heights.length - 1; i++) {
//             minht = heights[i];
//             sum = heights[i];
//             maxsum = Math.max(maxsum, sum);
//             for (int j = i + 1; j < heights.length; j++) {
//                 minht = Math.min(minht, Math.min(heights[i], heights[j]));
//                 sum = minht * (j - i + 1);
//                 maxsum = Math.max(maxsum, sum);
//             }
//         }
//         maxsum = Math.max(maxsum,heights[heights.length-1]);
//         return maxsum;
//     }

//     public static void main(String[] args) {
//         int[] heights = { 2, 1, 5, 6, 2, 3 };

//         System.out.println(largestRectangleArea(heights));
//     }
// }
import java.util.*;

class Solution {
    public static int largestRectangleArea(int[] heights) {
        int[] rs = new int[heights.length];
        int[] ls = new int[heights.length];
        Stack<Integer> s = new Stack<>();
        int maxarea = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            while (s.size() > 0 && heights[i] <= heights[s.peek()])
                s.pop();
            rs[i] = s.empty() ? heights.length : s.peek();
            s.push(i);
        }

        while (!s.empty())
            s.pop();

        for (int i = 0; i < heights.length; i++) {
            while (s.size() > 0 && heights[i] <= heights[s.peek()])
                s.pop();
            ls[i] = s.empty() ? -1 : s.peek();
            s.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (rs[i] - ls[i] - 1);
            maxarea = Math.max(maxarea, area);
        }

        return maxarea;
    }

    public static void main(String[] args) {
        // int[] heights = {2,1,5,6,2,3};
        int[] heights = { 2, 4 };
        System.out.println(largestRectangleArea(heights));
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
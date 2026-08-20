// 48. Rotate Image
// Medium
// Topics
// premium lock icon
// Companies
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
// Example 2:


// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

// Constraints:

// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
import java.util.*;
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        Deque<Integer> q = new ArrayDeque<>();
        helper(matrix, n, q, 0, 0);
        // return matrix;
    }

    public void helper(int[][] matrix, int n, Deque<Integer> q, int row, int col) {
        if (n <= 1)
            return;
        int size = n;
        int i = row;
        int j = col;
        int limit = size + col;
        while (j < limit - 1) {
            q.offerLast(matrix[i][j]);
            j++;
        }
        // j--;
        // i = 0;
        limit = size + row;
        while (i < limit - 1) {
            q.offerLast(matrix[i][j]);
            matrix[i][j] = q.pollFirst();
            i++;
        }

        // i--;
        // j = n-1;
        limit = col;
        while (j > limit) {
            q.offerLast(matrix[i][j]);
            matrix[i][j] = q.pollFirst();
            j--;
        }
        // pm(matrix);
        // System.out.println();
        // j++;
        // i = n-1;
        limit = row;
        while (i > limit) {
            q.offerLast(matrix[i][j]);
            matrix[i][j] = q.pollFirst();
            i--;
        }
        // i++;
        // j = 0;
        limit = size + col;
        while (j < limit - 1) {
            matrix[i][j] = q.pollFirst();
            j++;
        }
        // pm(matrix);
        while (!q.isEmpty())
            q.poll();
        helper(matrix, n - 2, q, row + 1, col + 1);
    }

    static void pm(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
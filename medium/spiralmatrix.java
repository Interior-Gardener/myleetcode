// 54. Spiral Matrix
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an m x n matrix, return all elements of the matrix in spiral order.

// Example 1:

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:

// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100

import java.util.*;

class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;

        return helper(res, matrix, 0, 0, matrix[0].length, matrix.length);
    }

    public static List<Integer> helper(List<Integer> res, int[][] matrix,
                                       int row, int col, int n, int m) {

        if (row >= m || col >= n) return res;

        // Top row
        for (int i = col; i <= n - 1; i++) {
            res.add(matrix[row][i]);
        }

        // Right column
        for (int i = row + 1; i <= m - 1; i++) {
            res.add(matrix[i][n - 1]);
        }

        // Bottom row
        if (row != m - 1) {
            for (int i = n - 2; i >= col; i--) {
                res.add(matrix[m - 1][i]);
            }
        }

        // Left column
        if (col != n - 1) {
            for (int i = m - 2; i > row; i--) {
                res.add(matrix[i][col]);
            }
        }

        return helper(res, matrix, row + 1, col + 1, n - 1, m - 1);
    }


    public static void main(String[] args) {
        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        // int[][] matrix = {{3},{2}};
        spiralOrder(matrix);
    }
}
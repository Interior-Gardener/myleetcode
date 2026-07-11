
// Code
// Testcase
// Testcase
// Test Result
// 2596. Check Knight Tour Configuration
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// There is a knight on an n x n chessboard. In a valid configuration, the knight starts at the top-left cell of the board and visits every cell on the board exactly once.

// You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1] where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.

// Return true if grid represents a valid configuration of the knight's movements or false otherwise.

// Note that a valid knight move consists of moving two squares vertically and one square horizontally, or two squares horizontally and one square vertically. The figure below illustrates all the possible eight moves of a knight from some cell.

// Example 1:

// Input: grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
// Output: true
// Explanation: The above diagram represents the grid. It can be shown that it is a valid configuration.
// Example 2:

// Input: grid = [[0,3,6],[5,8,1],[2,7,4]]
// Output: false
// Explanation: The above diagram represents the grid. The 8th move of the knight is not valid considering its position after the 7th move.

// Constraints:

// n == grid.length == grid[i].length
// 3 <= n <= 7
// 0 <= grid[row][col] < n * n
// All integers in grid are unique.
import java.util.*;

class Solution {
    public static class help {
        int row = -1;
        int col = -1;
        boolean ispresent = false;
    }

    public static boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0)
            return false;
        int row = 0, col = 0;
        int next = 1;
        // for(int i = 0 ; i <grid.length ; i++) {
        // for(int j = 0 ; j < grid.length ; j++) {
        // if(grid[i][j] == 0) {
        // row = i;
        // col = j;
        // }
        // }
        // }
        return helper(grid, next, row, col);
    }

    public static boolean helper(int[][] grid, int next, int row, int col) {
        if (next == grid.length * grid.length)
            return true;
        help result = check(grid, next, row, col);
        if (result.ispresent == true) {
            row = result.row;
            col = result.col;
            return helper(grid, next + 1, row, col);
        } else {
            return false;
        }
    }

    public static help check(int[][] grid, int next, int row, int col) {
        help ans = new help();
        if (row + 2 < grid.length && col + 1 < grid.length && grid[row + 2][col + 1] == next) {
            ans.row = row + 2;
            ans.col = col + 1;
            ans.ispresent = true;
            return ans;
        } else if (row + 2 < grid.length && col - 1 >= 0 && grid[row + 2][col - 1] == next) {
            ans.row = row + 2;
            ans.col = col - 1;
            ans.ispresent = true;
            return ans;
        } else if (row - 2 >= 0 && col - 1 >= 0 && grid[row - 2][col - 1] == next) {
            ans.row = row - 2;
            ans.col = col - 1;
            ans.ispresent = true;
            return ans;
        } else if (row - 2 >= 0 && col + 1 < grid.length && grid[row - 2][col + 1] == next) {
            ans.row = row - 2;
            ans.col = col + 1;
            ans.ispresent = true;
            return ans;
        } else if (row - 1 >= 0 && col + 2 < grid.length && grid[row - 1][col + 2] == next) {
            ans.row = row - 1;
            ans.col = col + 2;
            ans.ispresent = true;
            return ans;
        } else if (row - 1 >= 0 && col - 2 >= 0 && grid[row - 1][col - 2] == next) {
            ans.row = row - 1;
            ans.col = col - 2;
            ans.ispresent = true;
            return ans;
        } else if (row + 1 < grid.length && col + 2 < grid.length && grid[row + 1][col + 2] == next) {
            ans.row = row + 1;
            ans.col = col + 2;
            ans.ispresent = true;
            return ans;
        } else if (row + 1 < grid.length && col - 2 >= 0 && grid[row + 1][col - 2] == next) {
            ans.row = row + 1;
            ans.col = col - 2;
            ans.ispresent = true;
            return ans;
        } else
            return ans;
    }
}
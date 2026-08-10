
// Code
// 994. Rotting Oranges
// Attempted
// Medium
// Topics
// premium lock icon
// Companies
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

class Solution {
    public int orangesRotting(int[][] grid) {
        if (all4zero(grid))
            return -1;
        if (all0(grid))
            return 0;
        if (!contains2(grid))
            return -1;
        int[][] prev = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                prev[i][j] = grid[i][j];
            }
        }

        int count = 0;
        count = helper(grid, prev, 0);
        return count;
    }

    public int helper(int[][] grid, int[][] prev, int min) {
        pm(grid);
        System.out.println("New matrix");
        set2(grid, prev);
        if (isequal(grid, prev)) {
            return min;
        } else {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    prev[i][j] = grid[i][j];
                }
            }
            return helper(grid, prev, min + 1);
        }
        // return min;
    }

    public void set2(int[][] a, int[][] prev) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 2) {
                    if (prev[i][j] != 1) {
                        if (i - 1 >= 0 && a[i - 1][j] == 1)
                            a[i - 1][j] = 2;
                        if (i + 1 < a.length && a[i + 1][j] == 1)
                            a[i + 1][j] = 2;
                        if (j - 1 >= 0 && a[i][j - 1] == 1)
                            a[i][j - 1] = 2;
                        if (j + 1 < a[0].length && a[i][j + 1] == 1)
                            a[i][j + 1] = 2;
                    }
                }
            }
        }
    }

    public boolean contains2(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 2)
                    return true;
                ;
            }
        }
        return false;
    }

    public boolean all0(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public boolean isequal(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean all4zero(int[][] a) {
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    if (i - 1 >= 0 && a[i - 1][j] == 0)
                        up = true;
                    else if (i - 1 < 0)
                        up = true;
                    if (i + 1 < a.length && a[i + 1][j] == 0)
                        down = true;
                    else if (i + 1 >= a.length)
                        down = true;
                    if (j - 1 >= 0 && a[i][j - 1] == 0)
                        left = true;
                    else if (j - 1 < 0)
                        left = true;
                    if (j + 1 < a[0].length && a[i][j + 1] == 0)
                        right = true;
                    else if (j + 1 >= a[0].length)
                        right = true;
                    if (up && down && left && right)
                        return true;
                    else {
                        up = false;
                        down = false;
                        left = false;
                        right = false;
                    }
                }
            }
        }
        return false;
    }

    public void pm(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// 37. Sudoku Solver
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.

// Example 1:

// Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
// Explanation: The input board is shown above and the only valid solution is shown below:

// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit or '.'.
// It is guaranteed that the input board has only one solution.

import java.util.*;

class Solution {

    public void solveSudoku(char[][] board) {
        // helper(board, 0, 0);
        helper(board);
    }

    // public void helper(char[][] board, int row, int col) {
    // if (solved(board))
    // return;
    // row = row % 9;
    // col = col % 9;
    // for (int i = row; i < 9; i++) {
    // // System.out.println("here");
    // for (int j = col; j < 9; j++) {
    // if (board[i][j] == '.') {
    // for (int k = 0; k < 9; k++) {
    // if (isSafe(board, i, j, (char) (k + '1'))) {
    // board[i][j] = (char) (k + '1');
    // helper(board, i, j + 1);
    // if (solved(board))
    // return;
    // board[i][j] = '.';
    // }
    // }
    // }
    // }
    // }
    // }

    public void helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isSafe(board, i, j, c)) {
                            board[i][j] = c;
                            helper(board);
                            if (solved(board))
                                return;
                            board[i][j] = '.';
                        }
                    }
                    return;
                }
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (i == col) {
                continue;
            }
            if (board[row][i] == c) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][col] == c) {
                return false;
            }
        }

        int rowrange = row / 3;
        int colrange = col / 3;
        for (int i = rowrange * 3; i < (rowrange + 1) * 3; i++) {
            for (int j = colrange * 3; j < (colrange + 1) * 3; j++) {
                if (i == row && j == col)
                    continue;
                if (board[i][j] == c)
                    return false;
            }
        }

        return true;
    }

    boolean solved(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    return false;
            }
        }
        return true;
    }
}
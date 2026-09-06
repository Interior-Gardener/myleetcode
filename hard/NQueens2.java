// 52. N-Queens II
// Hard
// Topics
// premium lock icon
// Companies
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

// Example 1:


// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:

// Input: n = 1
// Output: 1
 

// Constraints:

// 1 <= n <= 9

// class Solution {
//     public int totalNQueens(int n) {
        
//     }
// }

import java.util.*;
class Solution {
    public static int totalNQueens(int n) {
        List<List<String>> res =  new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, res, 0);
        return res.size();
    }

    public static void helper(char[][] board , List<List<String>> res , int col){
        if(col == board.length){
            boardsave(board,res);
            return;
        }
        for(int row = 0; row<board.length; row++) {
            if(isSafe(board,col,row)){
                board[row][col] = 'Q';
                helper(board, res, col+1);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board,int col, int row) {
        //vertical
        for(int i = 0 ; i < board.length ; i++) {
            if(board[i][col] == 'Q') return false;
            

        }

        //horizontal
        for(int  j = 0 ; j <board.length ; j++) {
            if(board[row][j] == 'Q') return false;
        }

        //topleft
        for(int i = row , j = col ; j>=0 && i >=0 ; i--,j--){
            if(board[i][j] == 'Q') return false;
        }

        //topright
        for(int i = row , j = col ; i >=0 && j < board.length ; i--,j++) {
            if(board[i][j] == 'Q') return false;
        }

        //bottomleft
        for(int i = row , j= col ; i< board.length && j>=0 ; i++,j--){
            if(board[i][j] == 'Q') return false;
        }
        
        // bottom right
        for(int i = row , j= col ; i< board.length && j<board.length ; i++,j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void boardsave(char[][] board , List<List<String>> res) {
        List<String> temp = new ArrayList<>();
        String str = "";

        for(int i = 0 ; i < board.length ; i++){
           str = "";
           for(int j = 0 ; j <board[0].length ; j++){
                if(board[i][j] == 'Q'){
                    str+='Q';
                }
                else str+='.';
           }
           temp.add(str);
        }
        res.add(temp);
    }
}
// 51. N-Queens
// Hard
// Topics
// premium lock icon
// Companies
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

// Example 1:


// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// Example 2:

// Input: n = 1
// Output: [["Q"]]
import java.util.*;

class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res =  new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, res, 0);
        System.out.println(res);
        return res;
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

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
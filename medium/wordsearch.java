// 79. Word Search
// Medium
// Topics
// premium lock icon
// Companies
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example 1:

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.

// Follow up: Could you use search pruning to make your solution faster with a larger board?

class Solution {
    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, n, m, visited, i, j, false, 0))
                    return true;
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, String word, int n, int m,
            boolean[][] visited, int row, int col,
            boolean exist, int len) {

        if (len == word.length())
            return true;

        if (row < 0 || col < 0 || row >= n || col >= m || visited[row][col])
            return false;

        if (board[row][col] != word.charAt(len))
            return false;

        visited[row][col] = true;

        exist = dfs(board, word, n, m, visited, row + 1, col, exist, len + 1);
        if (exist) {
            visited[row][col] = false;
            return true;
        }

        exist = dfs(board, word, n, m, visited, row - 1, col, exist, len + 1);
        if (exist) {
            visited[row][col] = false;
            return true;
        }

        exist = dfs(board, word, n, m, visited, row, col + 1, exist, len + 1);
        if (exist) {
            visited[row][col] = false;
            return true;
        }

        exist = dfs(board, word, n, m, visited, row, col - 1, exist, len + 1);
        if (exist) {
            visited[row][col] = false;
            return true;
        }

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        // char[][] board1 = {
        // { 'A', 'B', 'C', 'E' },
        // { 'S', 'F', 'C', 'S' },
        // { 'A', 'D', 'E', 'E' }
        // };

        // String word1 = "ABCCED";

        // char[][] board2 = {
        // {'A', 'B', 'C', 'E'},
        // {'S', 'F', 'C', 'S'},
        // {'A', 'D', 'E', 'E'}
        // };

        // String word2 = "ABCB";

        // char[][] board3 = {
        // {'A', 'B', 'C', 'E'},
        // {'S', 'F', 'C', 'S'},
        // {'A', 'D', 'E', 'E'}
        // };

        // String word3 = "SEE";

        char[][] board4 = { { 'b', 'a', 'b', 'b', 'a' } };

        String word4 = "baa";

        System.out.println(exist(board4, word4));
    }
}
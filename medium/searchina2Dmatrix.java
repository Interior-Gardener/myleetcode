// 74. Search a 2D Matrix
// Medium
// Topics
// premium lock icon
// Companies
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Example 1:

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0]) return false;

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        if(target > matrix[row][col]) return false;

        if (row == 0 && col == 0) {
            if (target == matrix[row][col])
                return true;
            return false;
        }
        if (row == 0) {
            return BS(matrix[0], 0, col, target);
        }
        if (col == 0) {
            int low = 0, high = row;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (target == matrix[mid][0]) {
                    return true;
                } else if (target < matrix[mid][0]) {
                    high = mid - 1;
                    // present = low;
                } else {
                    low = mid + 1;
                    // present = low;
                }

            }
            return false;
        }
        // for(int i = 0 ; i < row ; i++ ) {
        // if(matrix[i][0] <= target && target <= matrix[i][col]) {
        // return BS(matrix[i],0,matrix[i].length-1 , target);
        // }
        // }

        // int[] firstcolumn = new int[row+1];
        // for (int i = 0; i <= row; i++) {
        // firstcolumn[i] = matrix[i][0];
        // }
        // printArr(firstcolumn);
        // int present = searchrowBS(firstcolumn, 0, row, target);
        // System.out.println(present + " present");
        // if (present == target)
        // return true;
        int present = -1;
        int low = 0, high = row;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target < matrix[mid][0]) {
                if(mid-1 >= 0 && target > matrix[mid-1][0]) {
                    present = mid-1;
                    break;
                }
                high = mid - 1;
                present = low;
            } else {
                if(mid+1 <= row && target < matrix[mid+1][0]) {
                    present = mid;
                    break;
                }
                low = mid + 1;
                present = low;
            }

        }
        if(target > matrix[row][0] && target <= matrix[row][col]) return BS(matrix[row], 0, col, target);
        // System.out.println(matrix[present]);
        System.out.println(present + " present");
        return BS(matrix[present], 0, col, target);
    }

    public boolean BS(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return true;

            else if (target < arr[mid])
                return BS(arr, low, mid - 1, target);

            else
                return BS(arr, mid + 1, high, target);
        }
        return false;
    }
    // public int searchrowBS(int[] arr, int low, int high, int target) {
    // int mid = low + (high - low) / 2;
    // while (low <= high) {
    // if (arr[mid] == target)
    // return target;

    // else if (target < arr[mid])
    // return searchrowBS(arr, low, mid - 1, target);

    // else
    // return searchrowBS(arr, mid + 1, high, target);
    // }
    // return low;
    // }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int[][] matrix = { { 1,1 } , { 2,2 }};
        int target = 2;

        System.out.println(sol.searchMatrix(matrix, target));
    }
}
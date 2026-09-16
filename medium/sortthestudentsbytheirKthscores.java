// 2545. Sort the Students by Their Kth Score
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// There is a class with m students and n exams. You are given a 0-indexed m x n integer matrix score, where each row represents one student and score[i][j] denotes the score the ith student got in the jth exam. The matrix score contains distinct integers only.

// You are also given an integer k. Sort the students (i.e., the rows of the matrix) by their scores in the kth (0-indexed) exam from the highest to the lowest.

// Return the matrix after sorting it.

// Example 1:

// Input: score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
// Output: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
// Explanation: In the above diagram, S denotes the student, while E denotes the exam.
// - The student with index 1 scored 11 in exam 2, which is the highest score, so they got first place.
// - The student with index 0 scored 9 in exam 2, which is the second highest score, so they got second place.
// - The student with index 2 scored 3 in exam 2, which is the lowest score, so they got third place.
// Example 2:

// Input: score = [[3,4],[5,6]], k = 0
// Output: [[5,6],[3,4]]
// Explanation: In the above diagram, S denotes the student, while E denotes the exam.
// - The student with index 1 scored 5 in exam 0, which is the highest score, so they got first place.
// - The student with index 0 scored 3 in exam 0, which is the lowest score, so they got second place.

// Constraints:

// m == score.length
// n == score[i].length
// 1 <= m, n <= 250
// 1 <= score[i][j] <= 105
// score consists of distinct integers.
// 0 <= k < n

import java.util.*;

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        ArrayList<Integer> temp = new ArrayList<>();

        int m = score.length;
        int n = score[0].length;

        for (int i = 0; i < m; i++) {
            temp.add(score[i][k]);
        }
        // System.out.println(temp);

        int up = 0;
        while (up < m) {
            int idx = getMaxIdx(temp);
            // System.out.println(idx + " " + up);
            swap(score, idx, up, m, n);
            swaplist(temp, idx, up);
            up++;
        }

        return score;
    }

    void swaplist(ArrayList<Integer> temp, int a, int b) {
        int t = temp.get(a);
        temp.set(a, temp.get(b));
        temp.set(b, t);
    }

    void swap(int[][] score, int idx, int up, int m, int n) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            temp.add(score[idx][i]);
        }

        for (int i = 0; i < n; i++) {
            score[idx][i] = score[up][i];
        }

        for (int i = 0; i < temp.size(); i++) {
            score[up][i] = temp.get(i);
        }
    }

    int getMaxIdx(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        int maxidx = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                maxidx = i;
            }
        }
        // System.out.println(maxidx);
        list.set(maxidx, -1);
        return maxidx;
    }
}
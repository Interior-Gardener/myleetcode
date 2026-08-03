// 530. Minimum Absolute Difference in BST
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

// Example 1:


// Input: root = [4,2,6,1,3]
// Output: 1
// Example 2:


// Input: root = [1,0,48,null,null,12,49]
// Output: 1
 

// Constraints:

// The number of nodes in the tree is in the range [2, 104].
// 0 <= Node.val <= 105
 

// Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Accepted but O(n)
// class Solution {
//     public int findmin(TreeNode root, int min , ArrayList<Integer> list) {
//         if(root == null) {
//             return min;
//         }
//         if(!list.isEmpty()) {
//             for(int i : list) {
//                 int temp = Math.abs(i - root.val);
//                 if(temp < min) {
//                     min = temp;
//                 }
//             }
//             list.add(root.val);
//         }
//         else {
//             list.add(root.val);
//         }
//     int min1 = findmin(root.left,min,list);
//     int min2 = findmin(root.right,min,list);
//     if(min1<=min2 && min1 < min) {
//         min = min1;
//     }
//     else if(min1 > min2 && min2 < min) {
//         min = min2;
//     }
//     return min;

//     }
//     public int getMinimumDifference(TreeNode root) {
//         int min = findmin(root,Integer.MAX_VALUE,new ArrayList<Integer>());
//         return min;
//     }
// }

// Solved with best time complexity this time O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ArrayList<Integer> inordertraversal(TreeNode root,ArrayList<Integer> list) {
        if(root == null) {
            return list;
        }
        inordertraversal(root.left,list);
        list.add(root.val);
        inordertraversal(root.right,list);
        return list;
    }
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>(inordertraversal(root,new ArrayList<>()));
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < result.size() ;i++) {
            if(result.get(i) - result.get (i-1) < min) {
                min = result.get(i) - result.get (i-1);
            }
        }
        return min;
    }
}
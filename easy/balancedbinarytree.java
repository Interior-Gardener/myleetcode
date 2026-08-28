
// Code
// 110. Balanced Binary Tree
// Attempted
// Easy
// Topics
// premium lock icon
// Companies
// Given a binary tree, determine if it is height-balanced.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:


// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true
 

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104

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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (root.right == null && root.left == null)
            return true;
        if (root.left == null) {
            if (height(root.right) == 1) {
                return true;
            }
            return false;
        }
        if (root.left == null) {
            if (height(root.left) == 1) {
                return true;
            }
            return false;
        }
        // int hl = height(root.left);
        // int hr = height(root.right);
        // System.out.println(hl + " " + hr);
        // if (Math.abs(hl - hr) == 1 || hl == hr)
        //     return true;
        // return false;
        return ht(TreeNode root);
    }

    public boolean height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = height(root.left);
        int hr = height(root.right);

        return Math.max(hl,  hr) + 1;
    }

    public boolean ht(TreeNode root) {
        
    }
}
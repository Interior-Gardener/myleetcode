// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Medium
// Topics
// premium lock icon
// Companies
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

// Example 1:


// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:

// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
 

// Constraints:

// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.

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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return new TreeNode();
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right)
            return null;

        TreeNode root = new TreeNode(preorder[idx++]);
        int newidx = 0;
        for (int i = left; i <= right; i++) {
            if (inorder[i] == root.val) {
                newidx = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, left, newidx - 1);
        root.right = helper(preorder, inorder, newidx + 1, right);
        return root;
    }
}

// 783. Minimum Distance Between BST Nodes
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

 

// Example 1:


// Input: root = [4,2,6,1,3]
// Output: 1
// Example 2:


// Input: root = [1,0,48,null,null,12,49]
// Output: 1
 

// Constraints:

// The number of nodes in the tree is in the range [2, 100].
// 0 <= Node.val <= 105
 

// Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/

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

// Wasted Attempt 1
// class Solution {
//     public int findmin(TreeNode root, int min){
//         if(root.left == null && root.right == null) {
//             return root.val;
//         }
//         if(root.left == null) {
//             int temp = (int)Math.abs(root.val-root.right.val);
//             if(temp<min){
//                 min = temp;
//                 return min;
//             }
//         }
//         else if(root.right == null ){
//             int temp = (int)Math.abs(root.val-root.left.val);
//             if(temp<min){
//                 min = temp;
//                 return min;
//             }
//         }
//         int min1 = findmin(root.left,min);
//         int min2 = findmin(root.right,min);
//         min = min1 <= min2 ? min1:min2;
//         return min;
//     }
//     public int minDiffInBST(TreeNode root) {
//         int min = findmin(root,Integer.MAX_VALUE);
//         return min;
//     }
// }

// Wasted ttempt 2
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
// class Solution {
//     public int findmin(TreeNode root, int min) {
//         if (root.left == null && root.right == null) {
//             return min;
//         }
//         if (root.left == null) {
//             int temp = Math.abs(root.val - root.right.val);
//             if (temp < min) {
//                 min = temp;
//             }
//             min = findmin(root.right, min);
//         }
//         if (root.right == null) {
//             int temp = Math.abs(root.val - root.left.val);
//             if (temp < min) {
//                 min = temp;
//             }
//             min = findmin(root.left, min);
//         }
//         if (root.left != null && root.right != null) {
//             int min1 = Math.abs(root.val - root.right.val);
//             int min2 = Math.abs(root.val - root.left.val);
//             // min = min1<= min2 ? min1:min2;
//             if (min1 <= min2 && min1 <= min) {
//                 min = min1;
//             } else if (min1 >= min2 && min2 <= min) {
//                 min = min2;
//             }
//             min = findmin(root.left, min);
//             min = findmin(root.right, min);
//         }
//         return min;
//     }

//     public int minDiffInBST(TreeNode root) {
//         int min = findmin(root, Integer.MAX_VALUE);
//         return min;
//     }
// }

// Finally did it
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
    public int findmin(TreeNode root, int min , ArrayList<Integer> list) {
        if(root == null) {
            return min;
        }
        if(!list.isEmpty()) {
            for(int i : list) {
                int temp = Math.abs(i - root.val);
                if(temp < min) {
                    min = temp;
                }
            }
            list.add(root.val);
        }
        else {
            list.add(root.val);
        }
    int min1 = findmin(root.left,min,list);
    int min2 = findmin(root.right,min,list);
    if(min1<=min2 && min1 < min) {
        min = min1;
    }
    else if(min1 > min2 && min2 < min) {
        min = min2;
    }
    return min;

    }
    public int minDiffInBST(TreeNode root) {
        int min = findmin(root,Integer.MAX_VALUE,new ArrayList<Integer>());
        return min;
    }
}
// 2265. Count Nodes Equal to Average of Subtree
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

// Note:

// The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
// A subtree of root is a tree consisting of root and all of its descendants.

// Example 1:

// Input: root = [4,8,5,0,1,null,6]
// Output: 5
// Explanation: 
// For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
// For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
// For the node with value 0: The average of its subtree is 0 / 1 = 0.
// For the node with value 1: The average of its subtree is 1 / 1 = 1.
// For the node with value 6: The average of its subtree is 6 / 1 = 6.
// Example 2:

// Input: root = [1]
// Output: 1
// Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// 0 <= Node.val <= 1000

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = 0;

    public int averageOfSubtree(TreeNode root) {
        int size = sizeoftree(root);
        sum = sumoftree(root);
        // System.out.println(sum + " " + size);
        int avg = sum / size;
        // int count = nodes(root, 0);
        // System.out.println(count);
        return nodes(root, 0);
    }

    public int sizeoftree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sizeoftree(root.left);
        int right = sizeoftree(root.right);

        return right + left + 1;
    }

    public int sumoftree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // sum += root.val;
        int left = 0;
        left += sumoftree(root.left);
        int right = 0;
        right += sumoftree(root.right);
        sum = left + right;

        return sum + root.val;
    }

    public int nodes(TreeNode root, int count) {
        if (root == null) {
            return count;
        }

        int sum = sumoftree(root);
        int size = sizeoftree(root);
        int avg = sum / size;

        if (root.val == avg) {
            count++;
        }

        count = nodes(root.left, count);
        count = nodes(root.right, count);

        return count;
    }
}
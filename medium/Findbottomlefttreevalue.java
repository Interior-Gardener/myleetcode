// 513. Find Bottom Left Tree Value
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given the root of a binary tree.

// Return the leftmost value in the last row of the tree.

// Example 1:

// Input: root = [2,1,3]
// Output: 1
// Explanation: The last row is [1,3], so the leftmost value is 1.
// Example 2:

// Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7
// Explanation: The last row contains only the node 7.

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1

/**
 * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 */

import java.util.*;

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

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode curr = root;
        while (!q.isEmpty()) {
            TreeNode last = q.poll();
            if (!q.isEmpty() && last == null) {
                q.add(null);
                // System.out.println("here");
                curr = q.peek();
                continue;
            }

            if (q.isEmpty() && last == null)
                break;

            if (last.left != null) {
                q.add(last.left);
            }
            if (last.right != null) {
                q.add(last.right);
            }
        }
        return curr.val;
    }
}
// 199. Binary Tree Right Side View
// Medium
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Example 1:

// Input: root = [1,2,3,null,5,null,4]

// Output: [1,3,4]

// Explanation:

// Example 2:

// Input: root = [1,2,3,4,null,null,null,5]

// Output: [1,3,4,5]

// Explanation:

// Example 3:

// Input: root = [1,null,3]

// Output: [1,3]

// Example 4:

// Input: root = []

// Output: []

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

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

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<TreeNode> res = new ArrayList<>();
        q.add(root);
        q.add(null);
        // TreeNode curr = root;
        while (!q.isEmpty()) {
            TreeNode last = q.poll();
            res.add(last);
            if (!q.isEmpty() && last == null) {
                q.add(null);
                // System.out.println("here");
                // curr = q.peek();
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
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(res.get(0).val);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == null && i - 1 >= 0) {
                list.add(res.get(i - 1).val);
            }
        }
        return list;
        // return curr.val;
    }
}

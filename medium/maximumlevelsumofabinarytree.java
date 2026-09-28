// 1161. Maximum Level Sum of a Binary Tree
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

// Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

// Example 1:

// Input: root = [1,7,0,7,-8,null,null]
// Output: 2
// Explanation: 
// Level 1 sum = 1.
// Level 2 sum = 7 + 0 = 7.
// Level 3 sum = 7 + -8 = -1.
// So we return the level with the maximum sum which is level 2.
// Example 2:

// Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
// Output: 2

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -105 <= Node.val <= 105

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

    public int maxLevelSum(TreeNode root) {
        return levelorder(root);
    }

    int levelorder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        ArrayList<TreeNode> list = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            list.add(temp);
            if (temp == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    continue;
                }
            }

            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        int sum = Integer.MIN_VALUE;
        int level = 0;
        int res = 1;
        // System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            int tempsum = 0;
            while (list.get(i) != null) {
                tempsum += list.get(i).val;
                i++;
            }
            level++;
            if (tempsum > sum) {
                sum = tempsum;
                res = level;
            }
        }
        return res;
    }
}

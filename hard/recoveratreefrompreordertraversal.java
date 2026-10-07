// 1028. Recover a Tree From Preorder Traversal
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// We run a preorder depth-first search (DFS) on the root of a binary tree.

// At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

// If a node has only one child, that child is guaranteed to be the left child.

// Given the output traversal of this traversal, recover the tree and return its root.

// Example 1:

// Input: traversal = "1-2--3--4-5--6--7"
// Output: [1,2,5,3,4,6,7]
// Example 2:

// Input: traversal = "1-2--3---4-5--6---7"
// Output: [1,2,5,3,null,6,null,4,null,7]
// Example 3:

// Input: traversal = "1-401--349---90--88"
// Output: [1,401,null,349,88,90]

// Constraints:

// The number of nodes in the original tree is in the range [1, 1000].
// 1 <= Node.val <= 109

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

    public TreeNode recoverFromPreorder(String s) {
        ArrayList<TreeNode> list = new ArrayList<>();
        int i = 0;
        int depth = 0;
        TreeNode root = new TreeNode();
        while (i < s.length()) {
            if (s.charAt(i) == '-') {
                depth++;
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && s.charAt(i) != '-') {
                sb.append(s.charAt(i));
                i++;
            }
            int num = Integer.parseInt(sb.toString());

            if (depth == 0) {
                root = new TreeNode(num);
                list.add(root);
                depth = 0;
                continue;
            }

            TreeNode temp = new TreeNode(num);
            if (list.get(depth - 1).left == null) {
                list.get(depth - 1).left = temp;
                if (list.size() <= depth) {
                    list.add(temp);
                } else {
                    list.set(depth, temp);
                }
            } else {
                list.get(depth - 1).right = temp;

                if (list.size() <= depth) {
                    list.add(temp);
                } else {
                    list.set(depth, temp);
                }
            }
            depth = 0;
        }
        return root;
    }
}
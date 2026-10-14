// 107. Binary Tree Level Order Traversal II
// Medium
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[15,7],[9,20],[3]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

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
 
     TreeNode() {}
 
     TreeNode(int val) { this.val = val; }
 
     TreeNode(int val, TreeNode left, TreeNode right) {
 
         this.val = val;
 
         this.left = left;
 
         this.right = right;
 
     }
 
 }
 
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);
        list.add(new ArrayList<>());
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                level++;
                list.add(new ArrayList<>());
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                list.get(level - 1).add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        list.removeLast();

        int l = 0;
        int r = list.size() - 1;
        while(l < r) {
            List<Integer> temp = list.get(l);
            list.set(l , list.get(r));
            list.set(r , temp);
            l++;
            r--;
        }
        return list;
    }
}
// 102. Binary Tree Level Order Traversal
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
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

    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<ArrayList<Integer>> list = new ArrayList<>();
    //     List<Integer> temp = new ArrayList<>();
    //     temp.add(root.val);
    //     list.add(temp);
    //     return addchild(root.left , root.right, list, 1);
    // }
    // // int level=1;
    // public static List<List<Integer>> addchild(TreeNode left , TreeNode right , List<List<Integer>> list, int level){
    //     if(left == null && right == null) return list;
    //     // ArrayList<Integer> temp = new ArrayList<>();
    //     if(left != null) list.get(level).add(left.val);
    //     if(right != null) list.get(level).add(right.val);
    //     level++;
    //     // // helper(left.left,left.right,temp);
    //     // // helper(right.left,right.right,temp);
    //     // list.add(temp);
    
    //     addchild(left.left, left.right, list, level);
    //     level = 1;
    //     addchild(right.left, right.right, list, level);
    //     return list;

    // }
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) return new ArrayList<List<Integer>>();
            List<List<Integer>> list = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            int level = 1;
            q.add(root);
            q.add(null);
            list.add(new ArrayList<>());
            while(!q.isEmpty()){
                TreeNode curr = q.remove();
                if(curr == null){
                    level++;
                    list.add(new ArrayList<>());
                    if(q.isEmpty()){ 
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
                    list.get(level-1).add(curr.val);
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
            }
            list.removeLast();
            return list;
    }    
}

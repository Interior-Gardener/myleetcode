// 1305. All Elements in Two Binary Search Trees
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

 

// Example 1:


// Input: root1 = [2,1,4], root2 = [1,0,3]
// Output: [0,1,1,2,3,4]
// Example 2:


// Input: root1 = [1,null,8], root2 = [8,1]
// Output: [1,1,8,8]
 

// Constraints:

// The number of nodes in each tree is in the range [0, 5000].
// -105 <= Node.val <= 105

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
        List<Integer> res = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder1(root1);
        inorder2(root2);
        int i = 0 , j = 0;
        while(i < temp1.size() && j < temp2.size()) {
            if(temp1.get(i) < temp2.get(j)) {
                res.add(temp1.get(i));
                i++;
            }
            else{
                res.add(temp2.get(j));
                j++;
            }
        }
        while(i < temp1.size()) {
            res.add(temp1.get(i));
            i++;
        }
        while(j < temp2.size()) {
            res.add(temp2.get(j));
            j++;
        }
        return res;
    }

    void inorder1(TreeNode root) {
        if(root == null) return;
        inorder1(root.left);
        temp1.add(root.val);
        inorder1(root.right);
    }
    void inorder2(TreeNode root) {
        if(root == null) return;
        inorder2(root.left);
        temp2.add(root.val);
        inorder2(root.right);
    }
}
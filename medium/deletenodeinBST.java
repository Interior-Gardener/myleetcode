
// Code
// Testcase
// Testcase
// Test Result
// 450. Delete Node in a BST
// Medium
// Topics
// premium lock icon
// Companies
// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
// Basically, the deletion can be divided into two stages:
// Search for a node to remove.
// If the node is found, delete the node.
// Example 1:
// Input: root = [5,3,6,2,4,null,7], key = 3
// Output: [5,4,6,2,null,null,7]
// Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
// One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
// Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
// Example 2:
// Input: root = [5,3,6,2,4,null,7], key = 0
// Output: [5,3,6,2,4,null,7]
// Explanation: The tree does not contain a node with value = 0.
// Example 3:
// Input: root = [], key = 0
// Output: []
// Constraints:
// The number of nodes in the tree is in the range [0, 104].
// -105 <= Node.val <= 105
// Each node has a unique value.
// root is a valid binary search tree.
// -105 <= key <= 105
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

    public static class TreeNode {

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

    public static TreeNode deleteNode(TreeNode root, int key) {
        // if (root == null) {
        //     return null;
        // }
        if(!search(root, key)) return root;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            //case 1 :  no child

            if (root.right == null && root.left == null) {
                return null;
            }

            //case 2 : one child
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }

            //case 3: 2 child
            TreeNode InorderSucc = FindInorderSuccessor(root.right);
            root.val = InorderSucc.val;
            root.right = deleteNode(root.right, InorderSucc.val);

        }
        return root;
    }

    public static TreeNode FindInorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static boolean search(TreeNode root , int key){
        if(root == null) return false;
        
        if(root.val < key) {
            return search(root.right , key);
        }
        else if (root.val == key) {
            return true;
        }
        else {
            return search(root.left , key);
        }
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static TreeNode insertBST(TreeNode root, int data) {
        if (root == null) {
            TreeNode newnode = new TreeNode(data);
            return newnode;
        }
        if (root.val < data) {
            root.right = insertBST(root.right, data);
        } else if (root.val > data) {
            root.left = insertBST(root.left, data);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insertBST(root, arr[i]);
        }
        
        // deleteNode(root, 6);
        deleteNode(root, 14);
        inorder(root);
    }
}

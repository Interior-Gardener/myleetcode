
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

    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        // TreeNode left = new TreeNode();
        // TreeNode right = new TreeNode();
        // left = root; 
        // right = root;

        return issym(root.left , root.right);
    }

    public static boolean issym(TreeNode left , TreeNode right){
        if(left == null && right == null) return true;
        if(left == null) return false;
        if(right == null) return false;

        if(left.val == right.val){
            return issym(left.left,right.right) && issym(left.right,right.left);
        }
        else{
            return false;
        }
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
    }
}

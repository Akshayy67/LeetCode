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
    TreeNode prev=null,root;
    public void flatten(TreeNode root) {
        prev=new TreeNode(0);
        rec(root);
    }
    public void rec(TreeNode root){
        if(root==null) return;
        TreeNode left=root.left;
        prev.right=root;
        prev=root;
        root.left=null;
        rec(left);
        rec(root.right);
    }
}
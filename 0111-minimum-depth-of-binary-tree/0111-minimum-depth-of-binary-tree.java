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
    int height=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        // if(root.left==null && root.right==null) return 0;
        helper(root,1);
        return height;
    }
    public void helper(TreeNode root,int n){
        if(root.left==null && root.right==null) height=Math.min(height,n);
        if(root.left!=null) helper(root.left,n+1);
        if(root.right!=null)helper(root.right,n+1);
    }
}
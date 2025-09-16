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
    int ans=0;
    int count=1,k;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        helper(root);
        return ans;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(count==k) ans=root.val;
        count++;
        helper(root.right);
    }
}
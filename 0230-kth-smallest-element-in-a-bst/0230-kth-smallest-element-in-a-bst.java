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
    TreeNode prev=null,start=null;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode dummy= new TreeNode(0);
        inord(root);
        while(k-->1){
            start=start.right;
        }
        return start.val;
    }
    public void inord(TreeNode root){
        if(root==null) return;
        inord(root.left);
        if(prev==null) {
            prev=root;
            start=root;
        }
        else{
             prev.right=root;
            prev=prev.right;
        }
        inord(root.right);
    }
}
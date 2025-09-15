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
    int result;
    public int sumNumbers(TreeNode root) {
        result=0;
        helper(root,0);
        return result;
    }
    public void helper(TreeNode root,int num){
        if(root==null) return;
        if(root.left==null && root.right==null){
            result+=(num*10+root.val);
            return;
        }
        num=num*10+root.val;
        helper(root.left,num);
        helper(root.right,num);
        num=num/10;
    }
}
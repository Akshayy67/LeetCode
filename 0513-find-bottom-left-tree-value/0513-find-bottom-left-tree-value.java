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
    int result=0, lvl=0;
    public int findBottomLeftValue(TreeNode root) {
        result=root.val;
        lvl=0;
        rec(root,0);
        return result;
    }
    public void rec(TreeNode root,int cur){
        if(root==null) return ;
        if(cur+1>lvl){
            lvl=cur+1;
            result=root.val;
        }
        cur++;
        rec(root.left,cur);
        rec(root.right,cur);
        cur--;
    }
}
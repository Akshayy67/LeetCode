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
    TreeNode root;
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        root=new TreeNode(nums[n/2]);
        rec(root,nums,0,n/2-1);
        rec(root,nums,n/2+1,nums.length-1);
        return root;
    }
    public void rec(TreeNode root,int[] nums, int l, int r){
        if(l>r) return;
        int mid=(l+r)/2;
        TreeNode nn= new TreeNode(nums[mid]);
        if(nn.val<root.val) root.left=nn;
        else root.right=nn;
        rec(nn,nums,l,mid-1);
        rec(nn,nums,mid+1,r);
    }
}
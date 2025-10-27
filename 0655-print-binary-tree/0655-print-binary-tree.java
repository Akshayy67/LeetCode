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
    List<List<String>> result= new ArrayList<>();
    int height;
    public List<List<String>> printTree(TreeNode root) {
        if(root==null) return result;
        this.height=height(root);
        for(int i=0;i<height;i++){
            result.add(new ArrayList<>());
            for(int j=0;j<Math.pow(2,height)-1;j++) result.get(i).add("");
        }
        build(0,0,(int)Math.pow(2,height)-1,root);
        return result;
    }
    public void build(int i,int left, int right,TreeNode root){
        if(root==null) return ;
        int mid=(left+right)/2;
        result.get(i).set(mid,root.val+"");
        build(i+1,left,mid-1,root.left);
        build(i+1,mid+1,right,root.right);
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
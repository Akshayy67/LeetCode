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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root==null) return result;
        List<Integer> path=new ArrayList<>();
        path.add(root.val);
        helper(root,path,targetSum-root.val);
        return result;
    }
    public void helper(TreeNode root,List<Integer> path,int sum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(sum==0) result.add(new ArrayList<>(path));
            return;
        }
        // if(sum<0) return;
        if(root.left!=null){
            path.add(root.left.val);
            helper(root.left,path,sum-root.left.val);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            path.add(root.right.val);
            helper(root.right,path,sum-root.right.val);
            path.remove(path.size()-1);
        }
    }
}
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
    Set<Integer> st= new HashSet<>();
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> mp= new HashMap<>();
        mp.put(0L,1);
        return helper(root,0,targetSum,mp);
    }
    public int helper(TreeNode root,long sum,int targetSum,Map<Long,Integer> mp){
        if(root==null) return 0;
        sum+=root.val;
        int count=mp.getOrDefault(sum-targetSum,0);
        mp.put(sum,mp.getOrDefault(sum,0)+1);
        count+=helper(root.left,sum,targetSum,mp);
        count+=helper(root.right,sum,targetSum,mp);
        mp.put(sum,mp.getOrDefault(sum,0)-1);
        return count;
    }
}
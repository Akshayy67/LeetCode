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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> lst= new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> inner= new ArrayList<>();
            while(size-->0){
                TreeNode cur=q.poll();
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
                inner.add(cur.val);
            }
            if(lst.size()%2==1) Collections.reverse(inner);
            lst.add(inner);
        }
        return lst;
    }
}
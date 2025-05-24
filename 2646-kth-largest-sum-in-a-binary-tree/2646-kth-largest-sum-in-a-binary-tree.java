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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq= new PriorityQueue<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            while(size-->0){
                TreeNode cur=q.poll();
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
                sum+=cur.val;
            }
            pq.offer(sum);
            if(pq.size()>k) pq.poll();
        }
        return pq.size()<k?-1:pq.peek();
    }
}
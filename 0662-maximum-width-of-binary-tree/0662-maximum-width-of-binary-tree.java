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
 class Pair{
    TreeNode r;
    int idx;
    public Pair(TreeNode r,int idx){
        this.r=r;
        this.idx=idx;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(root,0));
        int max=0;
        while(!q.isEmpty()){
            int size=q.size();
            int first=0,last=0;
            while(size-->0){
                Pair cur=q.poll();
                if(first==0) first=cur.idx;
                last=cur.idx;
                if(cur.r.left!=null) q.add(new Pair(cur.r.left,2*cur.idx+1));
                if(cur.r.right!=null) q.add(new Pair(cur.r.right,2*cur.idx+2));
            }
            max=Math.max(max,last-first+1);
        }
        return max;
    }
}
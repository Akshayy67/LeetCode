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
class BSTIterator {
    TreeNode root,prev;
    public BSTIterator(TreeNode r) {
        helper(r);
    }
    public void helper(TreeNode r){
        if(r==null) return;
        helper(r.left);
        if(root==null) root=r;
        if(prev!=null) prev.right=r;
        prev=r;
        helper(r.right);
    }
    
    public int next() {
        int val=root.val;
        root=root.right;
        return val;
    }
    
    public boolean hasNext() {
        return root!=null ;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
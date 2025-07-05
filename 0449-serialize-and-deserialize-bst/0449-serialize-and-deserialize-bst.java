/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder path= new StringBuilder();
        helper(root,path);
        return path.toString();
    }
    public void helper(TreeNode root,StringBuilder path){
        if(root==null) {
            path.append("#$");
            return;
        }
        path.append(root.val);
        path.append('$');
        helper(root.left,path);
        helper(root.right,path);
    }

    // Decodes your encoded data to tree.
    int idx;
    public TreeNode deserialize(String data) {
        idx=0;
        String[] strs= data.split("\\$");
        return build(strs);
    }
    public TreeNode build(String[] vals){
        if(idx>=vals.length || vals[idx].equals("#")){
            idx++;
            return null;
        }
        TreeNode root= new TreeNode(Integer.parseInt(vals[idx]));
        idx++;
        root.left=build(vals); 
        root.right=build(vals);
        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
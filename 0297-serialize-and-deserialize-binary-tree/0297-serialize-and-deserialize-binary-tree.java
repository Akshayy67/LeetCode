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
        if(root==null){
            path.append("#$");
            return ;
        }
        path.append(root.val+"$");
        helper(root.left,path);
        helper(root.right,path);
    }

    // Decodes your encoded data to tree.
    int idx=0;
    public TreeNode deserialize(String data) {
        String[] nodes=data.split("\\$");
        int idx=0;
        return build(nodes);
    }
    public TreeNode build(String[] data){
        if(idx>=data.length || data[idx].equals("#")){
            idx++;
            return null;
        }
        TreeNode cur=new TreeNode(Integer.parseInt(data[idx]));
        idx=idx+1;
        cur.left=build(data);
        cur.right=build(data);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
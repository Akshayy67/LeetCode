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
        StringBuilder str= new StringBuilder();
        shelper(root,str);
        return str.toString();
    }
    public void shelper(TreeNode root,StringBuilder str){
        if(root==null){
            str.append("#,");
            return;
        }
        str.append(root.val).append(",");
        shelper(root.left,str);
        shelper(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs=data.split(",");
        return dhelper(strs,new int[] {0});
    }
    public TreeNode dhelper(String[] data,int[] idx){
        if(data[idx[0]].equals("#")){
            idx[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(data[idx[0]]));
        idx[0]++;
        root.left=dhelper(data,idx);
        root.right=dhelper(data,idx);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
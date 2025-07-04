/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> mp= new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        mp.put(node,new Node(node.val));
        dfs(node);
        return mp.get(node);
    }
    public void dfs(Node node){
        for(Node neighbour:node.neighbors){
            if(!mp.containsKey(neighbour)){
                mp.put(neighbour,new Node(neighbour.val));
                dfs(neighbour);
            }
            mp.get(node).neighbors.add(mp.get(neighbour));
            
        }
    }
}
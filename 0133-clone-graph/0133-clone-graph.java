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
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node> mp= new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Set<Node> st= new HashSet<>();
        st.add(node);
        q.add(node);
        while(!q.isEmpty()){
            Node org=q.poll();
            mp.putIfAbsent(org, new Node(org.val));
            for(Node neighbour:org.neighbors){
                mp.putIfAbsent(neighbour, new Node(neighbour.val));
                mp.get(org).neighbors.add(mp.get(neighbour));
                if(st.add(neighbour))
                q.add(neighbour);
            }
        }
        return mp.get(node);
    }
}
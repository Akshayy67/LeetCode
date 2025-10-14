class Solution {
    int max=-1;
    Map<Integer,List<Integer>> mp;
    Set<Integer> visited;
    public int longestCycle(int[] edges) {
        mp= new HashMap<>();
        for(int i=0;i<edges.length;i++) mp.put(i,new ArrayList<>());
        for(int i=0;i<edges.length ;i++)
            if(edges[i]!=-1)
            mp.get(i).add(edges[i]);
        visited=new HashSet<>();
        Map<Integer,Integer> path;
        for(int i=0;i<edges.length;i++) {
            if(!visited.contains(i)){
                path = new HashMap<>();
                dfs(i,1,path);
            }
        }
        return max;
    }
    public void dfs(int node,int size,Map<Integer,Integer> path){
        if(visited.contains(node)) return;
        visited.add(node);
        path.put(node,size);
        for(int neighbor:mp.get(node)){
            if(path.containsKey(neighbor)) max=Math.max(1+size-path.get(neighbor),max);
            if(!visited.contains(neighbor))
            dfs(neighbor,size+1,path);
        }
    }
}
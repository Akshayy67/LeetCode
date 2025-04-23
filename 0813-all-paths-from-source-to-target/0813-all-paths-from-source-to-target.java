class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result= new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        path.add(0);
        rec(graph,0,path,new HashSet<>());
        return result;
    }
    public void rec(int[][] graph,int i,List<Integer> path,Set<Integer> visited){
        if(i==graph.length-1){
            result.add(new ArrayList<>(path));
            return;
        } 
        for(int neighbour:graph[i]){
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                path.add(neighbour);
                rec(graph,neighbour,path,visited);
                visited.remove(neighbour);
                path.remove(path.size()-1);
            }
        }
    }
}
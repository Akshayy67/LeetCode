class Solution {
    int[] visited;
    public boolean isBipartite(int[][] graph) {
        visited= new int[graph.length];
        // st= new HashSet<>();
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                if(!fs(graph,i,1)) return false;
                // count++;
            }
        }
        return true;
    }
    public boolean fs(int[][] grid,int v,int c){
        // if(visited[v]!=0) return true;
        for(int neighbour:grid[v]){
            if(visited[neighbour]==c){
                return false;
            }
            else if(visited[neighbour]==0){
            visited[neighbour]=c==1?2:1;
            if(!fs(grid,neighbour,c==1?2:1)) return false;
            }
        }
        return true;
    }
}
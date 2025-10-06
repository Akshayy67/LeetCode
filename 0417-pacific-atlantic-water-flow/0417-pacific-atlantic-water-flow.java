class Solution {
    int[][] directions= {{-1,0},{0,1},{1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result= new ArrayList<>();
        int n=heights.length,m=heights[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(helper(heights,i,j)) result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }
    public boolean helper(int[][] heights,int i, int j){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[] {i,j});
        boolean[][] visited= new boolean[heights.length][heights[0].length];
        visited[i][j]=true;
        boolean pacific=false,atlantic=false;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0],y=cur[1];
            if(x==0 || y==0) pacific=true;
            if(x==heights.length-1 || y==heights[0].length-1) atlantic=true;
            for(int[] dir:directions){
                int ni=x+dir[0];
                int nj=y+dir[1];
                if(valid(heights,ni,nj) && heights[ni][nj]<=heights[x][y] && !visited[ni][nj]){
                    q.offer(new int[] {ni,nj});
                    visited[ni][nj]=true;
                }
            }
            if(pacific&&atlantic) return true;
        }
        return pacific&&atlantic;
    }
    public boolean valid(int[][] grid,int i ,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}
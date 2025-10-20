class Solution {
    int[][] directions= {{-1,0},{0,1},{1,0},{0,-1}};
    boolean[][] visited;
    public int uniquePathsIII(int[][] grid) {
        visited= new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return dfs(grid,i,j);
            }
        }
        return -1;
    }
    public int dfs(int[][] grid,int i,int j){
        if(grid[i][j]==2) return completed(grid)?1:0;
        visited[i][j]=true;
        int count=0;
        for(int[] dir:directions){
            int ni=i+dir[0],nj=j+dir[1];
            if(isValid(grid,ni,nj)) count+=dfs(grid,ni,nj); 
        }
        visited[i][j]=false;
        return count;
    }
    public boolean isValid(int[][] grid,int i, int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]!=-1 && !visited[i][j];
    }
    public boolean completed(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=1 && grid[i][j] != 2 && grid[i][j]!=-1 && !visited[i][j]) return false; 
            }
        }
        return true;
    }
}
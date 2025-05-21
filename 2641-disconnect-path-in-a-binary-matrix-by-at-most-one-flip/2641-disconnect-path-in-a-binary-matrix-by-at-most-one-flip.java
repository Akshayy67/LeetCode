class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        if(!dfs(grid,0,0)) return true;
        grid[0][0]=1;
        return !dfs(grid,0,0);
    }
    private boolean dfs(int[][] grid, int i,int j){
        if(i==grid.length-1 && j==grid[0].length-1) return true;
        if(i==grid.length || j==grid[0].length || grid[i][j]==0) return false;
        grid[i][j]=0;
        if(dfs(grid,i+1,j)) return true;
        return dfs(grid,i,j+1);
    }
}
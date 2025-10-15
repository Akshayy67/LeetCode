class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1) return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) grid[i][j]=-1;
            }
        }
        grid[0][0]=1;
        for(int i=1;i<grid.length;i++){
            if(grid[i][0]!=-1) grid[i][0]+=grid[i-1][0];
        }
        for(int i=1;i<grid[0].length;i++){
            if(grid[0][i]!=-1) grid[0][i]+=grid[0][i-1];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                if(grid[i][j]==-1) continue;
                int top=grid[i-1][j]==-1?0:grid[i-1][j];
                int left=grid[i][j-1]==-1?0:grid[i][j-1];
                grid[i][j]=top+left;
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
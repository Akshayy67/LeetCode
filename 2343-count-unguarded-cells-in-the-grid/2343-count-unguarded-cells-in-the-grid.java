class Solution {
    int[][] directions= {{-1,0},{0,1},{1,0},{0,-1}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid= new int[m][n];
        for(int[] guard:guards) grid[guard[0]][guard[1]]=1;
        for(int[] wall:walls) grid[wall[0]][wall[1]]=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int[] dir=directions[k];
                        int ni=i+dir[0];
                        int nj=j+dir[1];
                        while(isValid(grid,ni,nj)){
                            grid[ni][nj]=2;
                            ni+=(k==0)?-1:(k==2?1:0);
                            nj+=(k==1)?1:(k==3?-1:0);
                        }
                    }
                }
            }
        }
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) result++;
            }
        }
        return result;
    }
    public boolean isValid(int[][] grid, int i,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]!=-1 && grid[i][j]!=1;
    }
}
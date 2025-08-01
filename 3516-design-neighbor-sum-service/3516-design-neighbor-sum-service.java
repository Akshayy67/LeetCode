class NeighborSum {
    int[][] adj= {{-1,0},{0,1},{1,0},{0,-1}};
    int[][] dia= {{-1,-1},{-1,1},{1,1},{1,-1}};
    int[][] grid;
    public NeighborSum(int[][] grid) {
        this.grid=grid;
    }
    
    public int adjacentSum(int value) {
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(value==grid[i][j]){
                    for(int dir[]:adj){
                        int ni=dir[0]+i;
                        int nj=dir[1]+j;
                        if(isValid(ni,nj,grid.length,grid[0].length)){
                            sum+=grid[ni][nj];
                        }
                    }
                }
            }
        }
        return sum;
    }
    
    public int diagonalSum(int value) {
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(value==grid[i][j]){
                    for(int dir[]:dia){
                        int ni=dir[0]+i;
                        int nj=dir[1]+j;
                        if(isValid(ni,nj,grid.length,grid[0].length)){
                            sum+=grid[ni][nj];
                        }
                    }
                }
            }
        }
        return sum;
    }
    public boolean isValid(int i,int j,int r, int c){
        return i>=0 && j>=0 && i<r && j<c;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
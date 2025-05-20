class Solution {
    int[][] directions= {{-2,-1},{-2,1},{-1,2},{1,2},{2,-1},{2,1},{1,-2},{-1,-2}};
    public boolean checkValidGrid(int[][] grid) {
        int n=grid.length;
        int finall= n*n -1;
        int[] cur= new int[] {0,0};
        if(grid[0][0]!=0) return false;
        while(cur.length!=0){
            cur=findNext(grid,cur);
            if(cur.length==0) return false;
            if(grid[cur[0]][cur[1]]==finall) return true;
        }
        return false;
    }
    public int[] findNext(int[][] grid,int[] idx){
        for(int[] dir:directions){
            int ni=idx[0]+dir[0];
            int nj=idx[1]+dir[1];
            if(valid(ni,nj,grid)){
                if(grid[ni][nj]==(grid[idx[0]][idx[1]]+1)) return new int[] {ni,nj};
            }
        }
        return new int[] {};
    }
    public boolean valid(int i,int j,int[][] grid){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}
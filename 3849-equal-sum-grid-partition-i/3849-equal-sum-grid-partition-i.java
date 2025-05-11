class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int sum=0,cur=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                sum+=grid[i][j];
            }
        }
        for(int i=0;i<grid.length;i++){
            if(sum==2*cur) return true;
            for(int j=0;j<grid[0].length;j++){
               cur+=grid[i][j];
            }
        }
        cur=0;
        for(int i=0;i<grid[0].length;i++){
            if(sum==2*cur) return true;
            for(int j=0;j<grid.length;j++){
               cur+=grid[j][i];
            }
        }
        return false;
    }
}
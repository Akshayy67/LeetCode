class Solution {
    Integer[][][] dp;
    int mod=(int)1e9+7;
    public int numberOfPaths(int[][] grid, int k) {
        dp= new Integer[grid.length][grid[0].length][k];
        return helper(grid,grid.length-1,grid[0].length-1,0,k);
    }
    public int helper(int[][] grid,int i,int j,int sum,int k){
        if(i==0 && j==0) return ((sum+grid[0][0])%k==0)?1:0;
        if(i<0 || j<0) return 0;
        sum=(sum+grid[i][j])%k;
        if(dp[i][j][sum]!=null) return dp[i][j][sum];
        return dp[i][j][sum]=(helper(grid,i-1,j,sum,k)%mod+helper(grid,i,j-1,sum,k)%mod)%mod;
    }
}
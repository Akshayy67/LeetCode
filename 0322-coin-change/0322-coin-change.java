class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp= new int[coins.length][amount+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        int result=helper(coins,amount,0);
        if(result>(int)1e5) return -1;
        return result;
    }
    public int helper(int[] coins,int amount,int i){
        if(amount==0) return 0;
        if(i==coins.length || amount<0) return (int) 1e6;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int leave=helper(coins,amount,i+1);
        int take=1+helper(coins,amount-coins[i],i);
        return dp[i][amount]=Math.min(leave,take);
    }
}
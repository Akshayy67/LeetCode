class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp= new Integer[amount+1][coins.length+1];
        int ans=helper(coins,amount,0);
        return ans>=(int)1e7?-1:ans;
    }
    public int helper(int[] coins,int amount,int i){
        if(amount==0) return 0;
        if(i==coins.length) return (int) 1e7;
        if(dp[amount][i]!=null) return dp[amount][i];
        int leave=helper(coins,amount,i+1);
        int take=(int)1e7;
        if(amount-coins[i]>=0) take=1+helper(coins,amount-coins[i],i);
        return dp[amount][i]=Math.min(take,leave);
    }
}
class Solution {
    int[] prices;
    int k;
    Integer[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp= new Integer[prices.length][2][k+1];
        this.prices=prices;
        this.k=k;
        return helper(0,0,0);
    }
    public int helper(int i,int holding,int cap){
        if(i==prices.length || cap==k) return 0;
        if(dp[i][holding][cap]!=null) return dp[i][holding][cap];
        int leave=helper(i+1,holding,cap);
        int buy=0,sell=0;
        if(holding==0) buy=helper(i+1,1,cap)-prices[i];
        else sell=prices[i]+helper(i+1,0,cap+1);
        return dp[i][holding][cap] =Math.max(leave,Math.max(sell,buy));
    }
}
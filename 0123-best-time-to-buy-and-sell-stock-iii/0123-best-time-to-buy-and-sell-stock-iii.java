class Solution {
    int[] prices;
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        this.prices=prices;
        dp= new Integer[prices.length][2][3];
        return helper(0,1,0);
    }
    public int helper(int i,int buy,int transaction){
        if(transaction==2 || i==prices.length) return 0;
        if(dp[i][buy][transaction]!=null) return dp[i][buy][transaction];
        int leave=helper(i+1,buy,transaction);
        int take=0;
        if(buy==1){
            take=-prices[i]+helper(i+1,0,transaction);
        }
        else{
            take=helper(i+1,1,transaction+1)+prices[i];
        }
        return dp[i][buy][transaction] =Math.max(take,leave);
    }
}
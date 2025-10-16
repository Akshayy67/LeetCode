class Solution {
    int[] prices;
    int[][][] dp;
    public int maxProfit(int[] prices) {
        this.prices=prices;
        dp= new int[prices.length][2][3];
         for (int i = 0; i < prices.length; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++)
                    dp[i][j][k] = -1;
        return helper(0,1,0);
    }
    public int helper(int i,int buy,int transaction){
        if(transaction==2 || i==prices.length) return 0;
        if(dp[i][buy][transaction]!=-1) return dp[i][buy][transaction];
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
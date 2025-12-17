class Solution {
    Long[][][] dp;
    public long maximumProfit(int[] prices, int k) {
        dp= new Long[k+1][prices.length][3];
        return helper(prices,k,0,0);
    }
    public long helper(int[] prices,int k,int i,int state){
        if(i==prices.length) return state == 0 ? 0 : Long.MIN_VALUE / 2;;
        if(k==0) return 0;
        if(dp[k][i][state]!=null) return dp[k][i][state];
        long leave=helper(prices,k,i+1,state);
        long take=0L;
        if(state==0) {
           take=Math.max(take,helper(prices,k,i+1,1)-prices[i]);
           take=Math.max(take,helper(prices,k,i+1,2)+prices[i]);
        }
        else if(state==1){
            take=helper(prices,k-1,i+1,0)+prices[i];
        }
        else{
            take=helper(prices,k-1,i+1,0)-prices[i];
        }
        return dp[k][i][state] = Math.max(take,leave);
    }
}
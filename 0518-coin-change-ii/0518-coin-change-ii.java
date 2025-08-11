// class Solution {
//     public int change(int amount, int[] coins) {
        
//     }
// }
class Solution {
    Integer[][] dp;
    public int change(int amount,int[] coins) {
        dp= new Integer[amount+1][coins.length+1];
        int ans=helper(coins,amount,0);
        return ans;
    }
    public int helper(int[] coins,int amount,int i){
        if(amount==0) return 1;
        if(i==coins.length) return 0;
        if(dp[amount][i]!=null) return dp[amount][i];
        int leave=helper(coins,amount,i+1);
        int take=0;
        if(amount-coins[i]>=0) take=helper(coins,amount-coins[i],i);
        return dp[amount][i]=take+leave;
    }
}
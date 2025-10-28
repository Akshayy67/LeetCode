class Solution {
    Integer[] dp;
    public int numSquares(int n) {
        dp=new Integer[n+1];
        return helper(n);
    }
    public int helper(int n){
        if(n==0) return 0;
        if(dp[n]!=null) return dp[n];
        int result=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            result=Math.min(result,helper(n-i*i));
        }
        return dp[n]=result+1;
    }
}
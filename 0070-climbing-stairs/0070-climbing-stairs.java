class Solution {
    int[] dp= new int[46];
    public int climbStairs(int n) {
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        return dp[n]=climbStairs(n-1)+climbStairs(n-2);
    }
}
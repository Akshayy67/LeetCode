class Solution {
    int mod=(int) 1e9+7;
    Integer[][] dp = new Integer[1002][1024];
    public int colorTheGrid(int m, int n) {
        helper(m,n,0,0,0,0);
        return dp[0][0];
    }
    public int helper(int m,int n,int r,int c, int prev_state,int cur_state){
        if(r==m) return helper(m,n,0,c+1,cur_state,0);
        if(n==c) return 1;
        if(r==0 && dp[c][prev_state]!=null) return dp[c][prev_state];
        int up=cur_state&3;
        int ways=0;
        for(int color=1;color<=3;color++){
            int left=((prev_state>>((m-r-1)*2))&3);
            if(color!=up && color!=left){
                cur_state<<=2;
                cur_state+=color;
                ways=(ways+helper(m,n,r+1,c,prev_state,cur_state))%mod;
                cur_state>>=2;
            }
        }
        if(r==0) dp[c][prev_state]=ways;
        return ways;
    }
}
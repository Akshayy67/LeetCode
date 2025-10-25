class Solution {
    long[][][] dp;
    public long numberOfWays(String s) {
        dp= new long[s.length()+1][4][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                for(int k=0;k<dp[i][j].length;k++) dp[i][j][k]=-1;
            }
        }
        return helper(s,0,3,-1);
    }
    public long helper(String s,int i,int count,int prev){
        if(count==0) return 1;
        if(i==s.length()) return 0;
        if(dp[i][count][prev+1]!=-1) return dp[i][count][prev+1];
        if(s.charAt(i)-'0'==prev) return dp[i][count][prev+1]= helper(s,i+1,count,prev);
        else return dp[i][count][prev+1]=  helper(s,i+1,count-1,s.charAt(i)-'0')+helper(s,i+1,count,prev);
    }
}
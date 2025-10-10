class Solution {
    public int longestCommonSubsequence(String s, String r) {
        int n=s.length();
        int m=r.length();
        int[][] dp= new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s.charAt(i)==r.charAt(j)) dp[i][j]=1+dp[i+1][j+1];
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
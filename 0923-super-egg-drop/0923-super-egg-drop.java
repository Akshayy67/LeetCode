class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp= new int[k+1][n+1];
        for(int i=0;i<=n;i++){
            dp[1][i]=i;
        }
        for(int i=2;i<=k;i++){
            for(int f=1;f<=n;f++){
                int min=Integer.MAX_VALUE;
                int low=1,high=f;
                while(low<=high){
                    int mid=(low+high)/2;
                    int breaks=dp[i-1][mid-1];
                    int survive=dp[i][f-mid];
                    int max=1+Math.max(breaks,survive);
                    if(breaks>survive) high=mid-1;
                    else low=mid+1;
                    min=Math.min(min,max);
                }
                // for(int j=1;j<=f;j++){
                //     int breaks=dp[i-1][j-1];
                //     int survive=dp[i][f-j];
                //     min=Math.min(Math.max(breaks,survive),min);
                // }
                dp[i][f]=min;
            }
        }
        return dp[k][n];
    }
}
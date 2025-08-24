class Solution {
    // int k,maxPts,n;
    // Map<Integer,Double> dp;
    public double new21Game(int n, int k, int maxPts) {
        if(k==0 || n>=maxPts+k-1) return 1;
        double[] dp= new double[n+1];
        dp[0]=1.0;
        double result=0.0,sum=1.0;
        for(int i=1;i<=n;i++){
            dp[i]=sum/maxPts;
            if(i<k) sum+=dp[i];
            else result+=dp[i];
            if(i-maxPts>=0) sum-=dp[i-maxPts];
        }
        return result;
    }
    // public double dfs(int score){
    //     if(score>=k) return score>n?0:1;
    //     if(dp.containsKey(score)) return dp.get(score);
    //     double sum=0;
    //     for(int i=1;i<=maxPts;i++){
    //         sum+=dfs(score+i);
    //     }
    //     dp.put(score,sum/(maxPts*1.0));
    //     return dp.get(score);
    // }
}
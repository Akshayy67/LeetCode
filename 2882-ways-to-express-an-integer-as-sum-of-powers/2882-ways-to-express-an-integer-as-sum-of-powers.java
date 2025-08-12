class Solution {
    Long[][] dp;
    int mod=(int)1e9+7;
    public int numberOfWays(int n, int x) {
       long i=1;
       List<Long> list= new ArrayList<>();
       while(Math.pow(i,x)<=n){
            list.add((long)Math.pow(i,x));
            i++;
       }
        dp= new Long[n+1][list.size()+1];
       return (int)ways(n,list,0);
    }
    public long ways(int sum,List<Long> list,int i){
        if(sum==0) return 1;
        if(sum<0) return 0;
        if(i==list.size()) return 0;
        if(dp[sum][i]!=null) return dp[sum][i];
        long leave=ways(sum,list,i+1)%mod;
        long take=ways((int)(sum-list.get(i)),list,i+1)%mod;
        return dp[sum][i]=(take+leave)%mod;
    }
}
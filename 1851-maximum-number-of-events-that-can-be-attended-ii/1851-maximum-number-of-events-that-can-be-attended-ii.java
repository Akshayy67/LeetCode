class Solution {
    Integer[][] dp;
    public int maxValue(int[][] events, int k) {
        dp= new Integer[k+1][events.length];
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        return helper(events,k,0);
    }
    public int helper(int[][] events,int k,int i){
        if(i>=events.length) return 0;
        if(k==0) return 0;
        if(dp[k][i]!=null) return dp[k][i];
        int leave=helper(events,k,i+1);
        int low=i+1,high=events.length-1,mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(events[mid][0]<=events[i][1]){
                low=mid+1;
            }
            else high=mid-1;
        }
        int take=events[i][2]+helper(events,k-1,low);
        return dp[k][i]=Math.max(take,leave);
        
    }
}
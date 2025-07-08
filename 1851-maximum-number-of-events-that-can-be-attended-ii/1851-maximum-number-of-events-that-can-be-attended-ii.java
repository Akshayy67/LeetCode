class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int n=events.length;
        int[][] dp= new int[k+1][events.length+1];
        for(int i=1;i<=k;i++){
            for(int j=n-1;j>=0;j--){
                int next=bs(events,j+1,events[j][1]);
                dp[i][j]=Math.max(dp[i][j+1],events[j][2]+dp[i-1][next]);
            }
        }
        return dp[k][0];
    }
    public int bs(int[][] events,int i,int target){
        int low=i,high=events.length-1,mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(events[mid][0]<=target) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}
// class Solution {
//     Integer[][] dp;
//     public int maxValue(int[][] events, int k) {
//         dp= new Integer[k+1][events.length];
//         Arrays.sort(events,(a,b)->a[0]-b[0]);
//         return helper(events,k,0);
//     }
//     public int helper(int[][] events,int k,int i){
//         if(i>=events.length) return 0;
//         if(k==0) return 0;
//         if(dp[k][i]!=null) return dp[k][i];
//         int leave=helper(events,k,i+1);
//         int low=i+1,high=events.length-1,mid=0;
//         while(low<=high){
//             mid=(low+high)/2;
//             if(events[mid][0]<=events[i][1]){
//                 low=mid+1;
//             }
//             else high=mid-1;
//         }
//         int take=events[i][2]+helper(events,k-1,low);
//         return dp[k][i]=Math.max(take,leave);
        
//     }
// }
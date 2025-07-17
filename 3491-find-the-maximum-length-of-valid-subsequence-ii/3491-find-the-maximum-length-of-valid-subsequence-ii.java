class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp= new int[k][k];
        int max=0;
        for(int num:nums){
            num%=k;
            for(int prev=0;prev<k;prev++){
                dp[num][prev]=dp[prev][num]+1;
                max=Math.max(max,dp[num][prev]);
            }
        }
        return max;
    }
}
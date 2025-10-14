class Solution {
   int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp= new int[nums.length][nums.length+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return helper(nums,0,-1);
    }
    public int helper(int[] nums ,int i,int prev){
        if(nums.length==i) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int leave=helper(nums,i+1,prev);
        int take=0;
        if(prev==-1 || nums[prev]<nums[i])
            take=1+helper(nums,i+1,i);
        return dp[i][prev+1]=Math.max(leave,take);
    }
}